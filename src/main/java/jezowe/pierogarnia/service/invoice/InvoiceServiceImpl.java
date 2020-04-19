package jezowe.pierogarnia.service.invoice;

import jezowe.pierogarnia.dto.invoice.InvoiceDetailsDTO;
import jezowe.pierogarnia.dto.invoice.InvoiceDetailsOrderDTO;
import jezowe.pierogarnia.exception.CanNotFindResourceProblem;
import jezowe.pierogarnia.mapper.InvoiceDetailsMapper;
import jezowe.pierogarnia.mapper.order.OrderMapper;
import jezowe.pierogarnia.model.InvoiceDetails;
import jezowe.pierogarnia.model.order.Order;
import jezowe.pierogarnia.model.order.Order_;
import jezowe.pierogarnia.repository.invoice.InvoiceRepository;
import jezowe.pierogarnia.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final OrderRepository orderRepository;
    private final InvoiceRepository invoiceRepository;

    @Override
    public InvoiceDetails create(Long orderId, InvoiceDetailsDTO invoiceDetailsDTO) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new CanNotFindResourceProblem("Order id not exist: " + orderId));
        InvoiceDetails invoiceDetails = new InvoiceDetails();
        invoiceDetails.create(order, invoiceDetailsDTO);

        return invoiceRepository.save(invoiceDetails);
    }

    @Override
    public List<InvoiceDetailsDTO> getOrdersWithPayerVat() {
        List<Order> orders = orderRepository.findAll(payerVat());
        List<InvoiceDetailsDTO> invoiceDetailsDTO = InvoiceDetailsMapper.INSTANCE.toInvoiceDetailsOrderDTOList(orders);

        return invoiceDetailsDTO;
    }

    private static Specification<Order> payerVat() {
        return (root, query, cb) -> cb.equal(root.get(Order_.PAYER_VAT), true);
    }
}
