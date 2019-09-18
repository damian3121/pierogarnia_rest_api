package jezowe.pierogarnia.model;

import javax.persistence.*;

@Entity
@Table(name = "testModel")
public class TestModel extends AuditModel {
    @Id
    @GeneratedValue(generator = "testModel_generator")
    @SequenceGenerator(
            name = "testModel_generator",
            sequenceName = "testModel_sequence",
            initialValue = 1000
    )
    private Long id;
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
