package jezowe.pierogarnia.controller.invoice;

import jezowe.pierogarnia.dto.invoice.InvoiceDetailsDTO;
import jezowe.pierogarnia.model.InvoiceDetails;
import jezowe.pierogarnia.service.invoice.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/invoice")
@RestController
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/{orderId}")
    public InvoiceDetails create(@PathVariable Long orderId, @RequestBody InvoiceDetailsDTO invoiceDetailsDTO) {

        return invoiceService.create(orderId, invoiceDetailsDTO);
    }

    @GetMapping
    public List<InvoiceDetailsDTO> getAll() {
        return invoiceService.getOrdersWithPayerVat();
    }
}
