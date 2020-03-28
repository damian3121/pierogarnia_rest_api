package jezowe.pierogarnia.controller.order;

import jezowe.pierogarnia.dto.order.OrderDTO;
import jezowe.pierogarnia.dto.order.OrderItemDTO;
import jezowe.pierogarnia.dto.order.UpdateOrderDTO;
import jezowe.pierogarnia.model.order.Order;
import jezowe.pierogarnia.service.order.OrderItemService;
import jezowe.pierogarnia.service.order.OrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/orders")
@RestController
public class OrderController {
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    public OrderController(OrderService orderService, jezowe.pierogarnia.service.order.OrderItemService orderItemService) {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public Order create(@RequestBody OrderDTO orderDTO) {

        return orderService.create(orderDTO);
    }

    @GetMapping
    public List<Order> orders() {

        return orderService.findAll();
    }

    @GetMapping(produces = "application/jezowe.pierogarnia.controller.order.getbydate+json")
    public Order getByDate(
            @RequestParam(name = "receiptOrderDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime receiptOrderDate,
            @RequestParam(name = "customerName") String customerName
    ) {
        return orderService.getByReceiptDate(receiptOrderDate, customerName);
    }

    @GetMapping(value = "/{id}")
    public Order getById(@PathVariable(value = "id") Long id) {

        return orderService.getById(id);
    }

    @PutMapping(value = "/{id}", produces = "application/jezowe.pierogarnia.controller.order.orderUpdate+json")
    public Order update(@PathVariable(value = "id") Long id, @RequestBody UpdateOrderDTO updateOrderDTO) {

        return orderService.update(id, updateOrderDTO);
    }

    @PutMapping(value = "/{id}", produces = "application/jezowe.pierogarnia.controller.order.orderProductsUpdate+json")
    public Order orderProductsUpdate(@PathVariable(value = "id") Long id, @RequestBody List<OrderItemDTO> updateOrderItemDTO) {

        return orderItemService.updateOrder(id, updateOrderItemDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        orderService.delete(id);
    }
}
