package jezowe.pierogarnia.dto.invoice;

import jezowe.pierogarnia.dto.order.OrderDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InvoiceDetailsOrderDTO extends OrderDTO{
    private InvoiceDTO invoiceDetails;
}
