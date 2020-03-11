package jezowe.pierogarnia.model.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String jwtToken;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;
}