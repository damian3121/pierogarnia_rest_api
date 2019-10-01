package jezowe.pierogarnia.service.user;

import jezowe.pierogarnia.dto.user.UserDTO;
import jezowe.pierogarnia.model.user.User;

import java.util.List;

public interface UserService {

    User save(UserDTO user);

    List<User> findAll();

    void delete(long id);

    User findOne(String username);

    User findById(Long id);
}
