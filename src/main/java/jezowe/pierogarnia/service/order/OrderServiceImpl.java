package jezowe.pierogarnia.service.order;

import jezowe.pierogarnia.dto.order.OrderDTO;
import jezowe.pierogarnia.dto.order.UpdateOrderDTO;
import jezowe.pierogarnia.exception.CanNotFindResourceProblem;
import jezowe.pierogarnia.mapper.order.OrderMapper;
import jezowe.pierogarnia.model.order.Order;
import jezowe.pierogarnia.model.order.Order_;
import jezowe.pierogarnia.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> getOrdersWithNotPayerVat() {
        List<Order> orders = orderRepository.findAll(notPayerVat());

        return orders;
    }

    @Override
    public Order create(OrderDTO orderDTO) {
        Order addedOrder = OrderMapper.INSTANCE.toOrder(orderDTO);
        addedOrder.setOrderDate(LocalDateTime.now());

        return orderRepository.save(addedOrder);
    }

    @Override
    public Order getByReceiptDate(LocalDateTime receiptOrderDate, String customerName) {
        Order order = orderRepository.findByReceiptDateAndCustomerName(
                receiptOrderDate, customerName)
                .orElseThrow(() -> new CanNotFindResourceProblem("Resource not exist (order by date and customer name): "
                        + receiptOrderDate + ": " + customerName));

        return order;
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new CanNotFindResourceProblem("Resource not exist (order id): " + id));
    }

    @Override
    public Order update(Long id, UpdateOrderDTO updateOrderDTO) {
        Order updatedOrder = orderRepository.findById(id).orElseThrow(() ->
                new CanNotFindResourceProblem("Resource not exist: " + updateOrderDTO.getCustomerName()));

        updatedOrder.update(updateOrderDTO);

        return orderRepository.save(updatedOrder);
    }

    @Override
    public void delete(Long id) {
        if (!checkIfOrderExistById(id)) {
            throw new CanNotFindResourceProblem("Resource not exist (order id): " + id);
        }

        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = OrderMapper.INSTANCE.toOrderDTOList(orders);

        return orderDTOs;
    }

    private boolean checkIfOrderExistById(Long id) {
        return orderRepository.existsById(id);
    }

    private static Specification<Order> notPayerVat() {
        return (root, query, cb) -> cb.notEqual(root.get(Order_.PAYER_VAT), false);
    }
}
