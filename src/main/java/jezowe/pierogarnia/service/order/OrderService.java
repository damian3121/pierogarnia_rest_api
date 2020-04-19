package jezowe.pierogarnia.service.order;

import jezowe.pierogarnia.dto.order.OrderDTO;
import jezowe.pierogarnia.dto.order.UpdateOrderDTO;
import jezowe.pierogarnia.model.order.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    Order create(OrderDTO orderDTO);

    Order getByReceiptDate(LocalDateTime receiptOrderDate, String customerName);

    Order getById(Long id);

    Order update(Long id, UpdateOrderDTO updateOrderDTO);

    void delete(Long id);

    List<OrderDTO> findAll();

    List<Order> getOrdersWithNotPayerVat();
}
