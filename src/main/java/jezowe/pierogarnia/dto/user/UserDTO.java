package jezowe.pierogarnia.dto.user;

import jezowe.pierogarnia.model.user.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private String username;
    private String password;
    private int age;
    private int salary;
    private Set<Role> roles;
}
