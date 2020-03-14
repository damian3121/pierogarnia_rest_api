package jezowe.pierogarnia.dto.order;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderByReceiptDateDTO {
    private LocalDateTime receiptOrderDate;
    private String customerSurname;
}
