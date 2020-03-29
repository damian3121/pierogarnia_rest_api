package jezowe.pierogarnia.dto.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {
    private BigDecimal quantity;
    private Long productId;
    private Long summaryPrice;
}
