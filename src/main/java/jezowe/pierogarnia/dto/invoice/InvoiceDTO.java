package jezowe.pierogarnia.dto.invoice;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InvoiceDTO {
    private LocalDate issueDate;
    private LocalDate paidDate;
    private LocalDate sellDate;
    private Long paymentToKind;
    private String status;
    private String paymentType;
    private String currency;
}
