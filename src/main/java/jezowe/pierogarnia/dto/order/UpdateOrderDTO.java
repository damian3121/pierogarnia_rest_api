package jezowe.pierogarnia.dto.order;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateOrderDTO {
    private LocalDateTime receiptDate;
    private String customerName;
    private String customerSurname;
    private String customerCompany;
}
