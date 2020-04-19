package jezowe.pierogarnia.mapper;

import jezowe.pierogarnia.dto.invoice.InvoiceDetailsDTO;
import jezowe.pierogarnia.model.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InvoiceDetailsMapper {
    InvoiceDetailsMapper INSTANCE = Mappers.getMapper(InvoiceDetailsMapper.class);

    @Mapping(target = "id", source = "invoiceDetails.id")
    @Mapping(target = "issueDate", source = "invoiceDetails.issueDate")
    @Mapping(target = "paidDate", source = "invoiceDetails.paidDate")
    @Mapping(target = "sellDate", source = "invoiceDetails.sellDate")
    @Mapping(target = "paymentToKind", source = "invoiceDetails.paymentToKind")
    @Mapping(target = "status", source = "invoiceDetails.status")
    @Mapping(target = "paymentType", source = "invoiceDetails.paymentType")
    @Mapping(target = "currency", source = "invoiceDetails.currency")
    @Mapping(target = "invoiceExtraNote", source = "invoiceDetails.invoiceExtraNote")
    @Mapping(target = "order", source = "order")
    InvoiceDetailsDTO toInvoiceDetailsDTO(Order order);



    List<InvoiceDetailsDTO> toInvoiceDetailsOrderDTOList(List<Order> orders);

}
