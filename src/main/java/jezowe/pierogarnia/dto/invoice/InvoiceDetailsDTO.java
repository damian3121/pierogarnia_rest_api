package jezowe.pierogarnia.dto.invoice;

import jezowe.pierogarnia.dto.order.OrderDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InvoiceDetailsDTO {
    private Long id;
    private LocalDate issueDate;
    private LocalDate paidDate;
    private LocalDate sellDate;
    private Long paymentToKind;
    private String status;
    private String paymentType;
    private String currency;
    private String invoiceExtraNote;
    private OrderDTO order;
}
