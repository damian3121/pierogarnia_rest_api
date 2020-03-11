package jezowe.pierogarnia.controller;

import jezowe.pierogarnia.dto.order.OrderDTO;
import jezowe.pierogarnia.dto.order.OrderItemDTO;
import jezowe.pierogarnia.dto.order.UpdateOrderDTO;
import jezowe.pierogarnia.model.order.Order;
import jezowe.pierogarnia.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/orders")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Order create(@RequestBody OrderDTO orderDTO) {

        return orderService.create(orderDTO);
    }

    @RequestMapping(value = "/{id}/item/create", method = RequestMethod.POST)
    public void createOrderItem(@PathVariable(value = "id") Long id, @RequestBody OrderItemDTO orderItemDTO) {
        orderService.addOrderItem(id, orderItemDTO);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        orderService.delete(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Order update(@PathVariable(value = "id") Long id, @RequestBody UpdateOrderDTO updateOrderDTO) {

        return orderService.update(id, updateOrderDTO);
    }
}
