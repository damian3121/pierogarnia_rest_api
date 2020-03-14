package jezowe.pierogarnia.controller.order;

import jezowe.pierogarnia.dto.order.OrderItemDTO;
import jezowe.pierogarnia.service.order.OrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/order-items")
@RestController
public class OrderItemController {
    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping(value = "/order/{id}")
    public void create(@PathVariable(value = "id") Long id, @RequestBody List<OrderItemDTO> orderItemsDTO) {
        orderItemService.create(id, orderItemsDTO);
    }

    @DeleteMapping(value = "/{orderItemId}/order/{orderId}")
    public void delete(@PathVariable(value = "orderId") Long orderId, @PathVariable(value = "orderItemId") Long orderItemId) {
        orderItemService.delete(orderId, orderItemId);
    }
}
