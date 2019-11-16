package jezowe.pierogarnia.service.user;

import jezowe.pierogarnia.dto.user.UserDTO;
import jezowe.pierogarnia.model.user.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    User save(UserDTO userDTO);

    void updateTokenByUsername(String username, String jwtToken, Date dateTime);

    List<User> findAll();

    User findById(Long id);

    User findByUsername(String username);

    void changeUserPassword(final User user, final String password);

    boolean checkIfValidOldPassword(final User user, final String oldPassword);
}
