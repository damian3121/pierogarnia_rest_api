package jezowe.pierogarnia.dto.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {
//    private Long id;
    private String productName;
    private BigDecimal summaryPrice;
    private BigDecimal quantity;
    private Long productId;
}
