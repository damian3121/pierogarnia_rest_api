package jezowe.pierogarnia.service.invoice;

import jezowe.pierogarnia.dto.invoice.InvoiceDetailsDTO;
import jezowe.pierogarnia.model.InvoiceDetails;

import java.util.List;

public interface InvoiceService {
    InvoiceDetails create(Long orderId, InvoiceDetailsDTO invoiceDetailsDTO);

    List<InvoiceDetailsDTO> getOrdersWithPayerVat();
}
