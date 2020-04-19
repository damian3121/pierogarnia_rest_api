package jezowe.pierogarnia.dto.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private LocalDateTime receiptDate;
    private String customerName;
    private Long customerId;
    private BigDecimal summaryPrice;
    private Boolean payerVat;
    private Boolean issuedInvoice;
    private Set<OrderItemDTO> orderItems;
}
