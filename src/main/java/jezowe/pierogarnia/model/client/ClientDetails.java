package jezowe.pierogarnia.model.client;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "clientDetails")
public class ClientDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long fktCustomerId;
    private String extraInfoClientName;
    private String extraInfo;
}
