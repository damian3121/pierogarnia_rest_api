package jezowe.pierogarnia.service.user;

import jezowe.pierogarnia.dao.user.UserDAO;
import jezowe.pierogarnia.dto.user.UserDTO;
import jezowe.pierogarnia.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(Long id) {
        return userDAO.findById(id).get();
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public void changeUserPassword(User user, String password) {
        user.setPassword(bcryptEncoder.encode(password));
        userDAO.save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(User user, String oldPassword) {
        return bcryptEncoder.matches(oldPassword, user.getPassword());
    }

    @Override
    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setRoles(user.getRoles());
        return userDAO.save(newUser);
    }

    @Override
    public void updateTokenByUsername(String username, String jwtToken, Date dateTime) {
        User updateUser = userDAO.findByUsername(username);
        updateUser.setJwtToken(jwtToken);
        updateUser.setDateTime(dateTime);

        userDAO.save(updateUser);
    }
}
