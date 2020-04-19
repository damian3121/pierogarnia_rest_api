package jezowe.pierogarnia.mapper.order;

import jezowe.pierogarnia.dto.invoice.InvoiceDetailsOrderDTO;
import jezowe.pierogarnia.dto.order.OrderDTO;
import jezowe.pierogarnia.model.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {OrderItemMapper.class})
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "orderDate", source = "orderDate")
    @Mapping(target = "receiptDate", source = "receiptDate")
    @Mapping(target = "customerName", source = "customerName")
    @Mapping(target = "customerId", source = "customerId")
    @Mapping(target = "summaryPrice", source = "summaryPrice")
    @Mapping(target = "orderItems", source = "orderItems")
    @Mapping(target = "payerVat", source = "payerVat")
    @Mapping(target = "issuedInvoice", source = "issuedInvoice")
    Order toOrder(OrderDTO orderDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "orderDate", source = "orderDate")
    @Mapping(target = "receiptDate", source = "receiptDate")
    @Mapping(target = "customerName", source = "customerName")
    @Mapping(target = "customerId", source = "customerId")
    @Mapping(target = "summaryPrice", source = "summaryPrice")
    @Mapping(target = "orderItems", source = "orderItems")
    @Mapping(target = "payerVat", source = "payerVat")
    @Mapping(target = "issuedInvoice", source = "issuedInvoice")
    OrderDTO toOrderDTO(Order order);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "orderDate", source = "orderDate")
    @Mapping(target = "receiptDate", source = "receiptDate")
    @Mapping(target = "customerName", source = "customerName")
    @Mapping(target = "customerId", source = "customerId")
    @Mapping(target = "summaryPrice", source = "summaryPrice")
    @Mapping(target = "orderItems", source = "orderItems")
    @Mapping(target = "issuedInvoice", source = "issuedInvoice")
    @Mapping(target = "payerVat", source = "payerVat")
    @Mapping(target = "invoiceDetails", source = "invoiceDetails")
    Order toInvoiceDetailsOrderDTO(InvoiceDetailsOrderDTO invoiceDetailsOrderDTO);

    List<InvoiceDetailsOrderDTO> toInvoiceDetailsOrderDTOList(List<Order> orders);

    List<OrderDTO> toOrderDTOList(List<Order> orders);
}
