package jezowe.pierogarnia.model;

import jezowe.pierogarnia.dto.invoice.InvoiceDetailsDTO;
import jezowe.pierogarnia.model.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "invoices")
public class InvoiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate issueDate;
    private LocalDate paidDate;
    private LocalDate sellDate;
    private Long paymentToKind;
    private String status;
    private String paymentType;
    private String currency;
    private String invoiceExtraNote;
    @OneToOne
    @MapsId
    private Order order;

    public void create(Order order, InvoiceDetailsDTO invoiceDetailsDTO) {
        this.setIssueDate(invoiceDetailsDTO.getIssueDate());
        this.setPaidDate(invoiceDetailsDTO.getPaidDate());
        this.setSellDate(invoiceDetailsDTO.getSellDate());
        this.setPaymentToKind(invoiceDetailsDTO.getPaymentToKind());
        this.setStatus(invoiceDetailsDTO.getStatus());
        this.setPaymentType(invoiceDetailsDTO.getPaymentType());
        this.setCurrency(invoiceDetailsDTO.getCurrency());
        this.setInvoiceExtraNote(invoiceDetailsDTO.getInvoiceExtraNote());
        order.setIssuedInvoice(true);
        this.setOrder(order);
    }
}
