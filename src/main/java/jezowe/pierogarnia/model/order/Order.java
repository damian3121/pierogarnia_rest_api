package jezowe.pierogarnia.model.order;

import jezowe.pierogarnia.dto.order.UpdateOrderDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime orderDate;
    private LocalDateTime receiptDate;
    private String customerName;
    @Nullable
    private Long customerId;
    @Nullable
    private BigDecimal summaryPrice;
    private Boolean payerVat;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>(0);

    public void update(UpdateOrderDTO updateOrderDTO) {
        this.setReceiptDate(updateOrderDTO.getReceiptDate());
        this.setCustomerId(updateOrderDTO.getCustomerId());
        this.setCustomerName(updateOrderDTO.getCustomerName());
        this.setPayerVat(updateOrderDTO.getPayerVat());
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    public void addOrderItems(List<OrderItem> orderItems) {
        BigDecimal sumSummaryPrice = orderItems.stream().map(it -> it.getSummaryPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);

        removeAllOrderItems();
        orderItems.forEach(it -> addOrderItem(it));
        this.setSummaryPrice(sumSummaryPrice);
    }

    private void removeAllOrderItems() {
        this.getOrderItems().clear();
    }

    public void deleteOrderItem(OrderItem orderItem) {
        this.orderItems.remove(orderItem);
    }
}
