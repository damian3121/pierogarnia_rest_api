package jezowe.pierogarnia.service.order;

import jezowe.pierogarnia.dto.order.OrderDTO;
import jezowe.pierogarnia.dto.order.OrderItemDTO;
import jezowe.pierogarnia.dto.order.UpdateOrderDTO;
import jezowe.pierogarnia.exception.CanNotFindResourceProblem;
import jezowe.pierogarnia.mapper.order.OrderItemMapper;
import jezowe.pierogarnia.mapper.order.OrderMapper;
import jezowe.pierogarnia.model.order.Order;
import jezowe.pierogarnia.model.order.OrderItem;
import jezowe.pierogarnia.repository.order.OrderItemRepository;
import jezowe.pierogarnia.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Order create(OrderDTO orderDTO) {
        Order addedOrder = OrderMapper.INSTANCE.toOrder(orderDTO);
        return orderRepository.save(addedOrder);
    }

    @Override
    public void delete(Long id) {
        if (!checkIfOrderExistById(id)) {
            throw new CanNotFindResourceProblem("Resource not exist (order id): " + id);
        }

        orderRepository.deleteById(id);
    }

    @Override
    public Order update(Long id, UpdateOrderDTO updateOrderDTO) {
        Order updatedOrder = orderRepository.findById(id).orElseThrow(() ->
                new CanNotFindResourceProblem("Resource not exist: " + updateOrderDTO.getCustomerCompany()));

        updatedOrder.updateOrder(updateOrderDTO);

        return orderRepository.save(updatedOrder);
    }

    @Override
    public Order addOrderItem(Long id, OrderItemDTO orderItemDTO) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new CanNotFindResourceProblem("Resource not exist (order id): " + id));
        OrderItem addedOrderItem = OrderItemMapper.INSTANCE.toOrderItem(orderItemDTO);

        order.addOrderItem(addedOrderItem);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderItem(Long orderId, Long orderItemId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new CanNotFindResourceProblem("Resource not exist (order id): " + orderId));

        OrderItem deletingOrderItem = orderItemRepository.findById(orderItemId).orElseThrow(() ->
                new CanNotFindResourceProblem("Resource not exist (orderItem id): " + orderItemId));

        order.deleteOrderItem(deletingOrderItem);
        orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    private boolean checkIfOrderExistById(Long id) {
        return orderRepository.existsById(id);
    }

}
