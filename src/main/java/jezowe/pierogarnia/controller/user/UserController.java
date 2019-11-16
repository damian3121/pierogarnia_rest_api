package jezowe.pierogarnia.controller.user;

import jezowe.pierogarnia.dto.user.PasswordDTO;
import jezowe.pierogarnia.dto.user.UserDTO;
import jezowe.pierogarnia.exception.InvalidOldPasswordException;
import jezowe.pierogarnia.model.user.User;
import jezowe.pierogarnia.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> listUser() {
        return userService.findAll();
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDTO user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/save-password", method = RequestMethod.POST)
    public void savePassword(@RequestBody PasswordDTO passwordDTO) {

        User user = userService.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName()
        );

        if (!userService.checkIfValidOldPassword(user, passwordDTO.getOldPassword())) {
            throw new InvalidOldPasswordException("Invalid old password");
        }

        userService.changeUserPassword(user, passwordDTO.getNewPassword());
    }
}