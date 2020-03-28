package jezowe.pierogarnia.service.order;

import jezowe.pierogarnia.dto.order.OrderItemDTO;
import jezowe.pierogarnia.exception.CanNotFindResourceProblem;
import jezowe.pierogarnia.mapper.order.OrderItemMapper;
import jezowe.pierogarnia.model.order.Order;
import jezowe.pierogarnia.model.order.OrderItem;
import jezowe.pierogarnia.repository.order.OrderItemRepository;
import jezowe.pierogarnia.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;


    @Override
    public Order create(Long id, List<OrderItemDTO> orderItemsDTO) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new CanNotFindResourceProblem("Resource not exist (order id): " + id));
        List<OrderItem> addedOrderItems = OrderItemMapper.INSTANCE.toOrderItemList(orderItemsDTO);

        order.addOrderItems(addedOrderItems);
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long orderId, List<OrderItemDTO> orderItemDTO) {
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new CanNotFindResourceProblem("Resource not exist (order id): " + orderId));
        List<OrderItem> addedOrderItem = OrderItemMapper.INSTANCE.toOrderItemList(orderItemDTO);

        order.addOrderItems(addedOrderItem);
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long orderId, Long orderItemId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new CanNotFindResourceProblem("Resource not exist (order id): " + orderId));

        OrderItem deletingOrderItem = orderItemRepository.findById(orderItemId).orElseThrow(() ->
                new CanNotFindResourceProblem("Resource not exist (orderItem id): " + orderItemId));

        order.deleteOrderItem(deletingOrderItem);
        orderRepository.save(order);
    }
}
