package jezowe.pierogarnia.service.order;

import jezowe.pierogarnia.dto.order.OrderDTO;
import jezowe.pierogarnia.dto.order.UpdateOrderDTO;
import jezowe.pierogarnia.exception.CanNotFindResourceProblem;
import jezowe.pierogarnia.mapper.order.OrderMapper;
import jezowe.pierogarnia.model.order.Order;
import jezowe.pierogarnia.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order create(OrderDTO orderDTO) {
        Order addedOrder = OrderMapper.INSTANCE.toOrder(orderDTO);
        addedOrder.setOrderDate(LocalDateTime.now());

        return orderRepository.save(addedOrder);
    }

    @Override
    public Order getByReceiptDate(LocalDateTime receiptOrderDate, String customerSurname) {
        Order order = orderRepository.findByReceiptDateAndCustomerSurname(
                receiptOrderDate, customerSurname)
                .orElseThrow(() -> new CanNotFindResourceProblem("Resource not exist (order by date and customer name): "
                        + receiptOrderDate + ": " + customerSurname));

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
                new CanNotFindResourceProblem("Resource not exist: " + updateOrderDTO.getCustomerCompany()));

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
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    private boolean checkIfOrderExistById(Long id) {
        return orderRepository.existsById(id);
    }

}
