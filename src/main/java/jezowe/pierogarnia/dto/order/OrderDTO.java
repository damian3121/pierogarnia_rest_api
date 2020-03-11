package jezowe.pierogarnia.dto.order;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private LocalDateTime receiptDate;
    private String customerName;
    private String customerSurname;
    private String customerCompany;
    private Set<OrderItemDTO> orderItemDTO;
}
