package jezowe.pierogarnia.mapper.order;

import jezowe.pierogarnia.dto.order.OrderItemDTO;
import jezowe.pierogarnia.model.order.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    @Mapping(target = "productName", source = "productName")
    @Mapping(target = "summaryPrice", source = "summaryPrice")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "productId", source = "productId")
    OrderItem toOrderItem(OrderItemDTO orderItems);

    Set<OrderItem> mapToOrderItemSet(Set<OrderItemDTO> orderItemDTOS);
}
