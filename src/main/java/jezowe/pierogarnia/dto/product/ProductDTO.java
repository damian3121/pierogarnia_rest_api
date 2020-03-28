package jezowe.pierogarnia.dto.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal fktPriceNet;
    private BigDecimal fktPriceGross;
    private Long fktProductId;
}
