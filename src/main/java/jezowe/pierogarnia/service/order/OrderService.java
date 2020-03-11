package jezowe.pierogarnia.service.order;

import jezowe.pierogarnia.dto.order.OrderDTO;
import jezowe.pierogarnia.dto.order.OrderItemDTO;
import jezowe.pierogarnia.dto.order.UpdateOrderDTO;
import jezowe.pierogarnia.model.order.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Order create(OrderDTO orderDTO);

    Order addOrderItem(Long id, OrderItemDTO orderItemDTO);

    void delete(Long id);

    Order update(Long id, UpdateOrderDTO updateOrderDTO);
}
