package jezowe.pierogarnia.model.product;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal fktPriceNet;
    private BigDecimal fktPriceGross;
    private Long fktProductId;
}
