package jezowe.pierogarnia.mapper.order;

import jezowe.pierogarnia.dto.order.OrderDTO;
import jezowe.pierogarnia.model.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {OrderItemMapper.class})
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "orderDate", source = "orderDate")
    @Mapping(target = "receiptDate", source = "receiptDate")
    @Mapping(target = "customerName", source = "customerName")
    @Mapping(target = "customerId", source = "customerId")
    @Mapping(target = "summaryPrice", source = "summaryPrice")
    @Mapping(target = "orderItems", source = "orderItemDTO")
    Order toOrder(OrderDTO orderDTO);
}
