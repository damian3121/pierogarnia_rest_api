package jezowe.pierogarnia.repository.user;

import jezowe.pierogarnia.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
