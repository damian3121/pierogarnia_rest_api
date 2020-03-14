package jezowe.pierogarnia.service.order;

import jezowe.pierogarnia.dto.order.OrderItemDTO;
import jezowe.pierogarnia.model.order.Order;

import java.util.List;

public interface OrderItemService {

    Order create(Long id, List<OrderItemDTO> orderItemsDTO);

    Order updateOrder(Long orderId, List<OrderItemDTO> orderItemDTO);

    void delete(Long orderId, Long orderItemId);

}
