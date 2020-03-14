package jezowe.pierogarnia.model.order;

import jezowe.pierogarnia.dto.order.UpdateOrderDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
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
    private String customerSurname;
    @Nullable
    private String customerCompany;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>(0);

    public void update(UpdateOrderDTO updateOrderDTO) {
        this.setReceiptDate(updateOrderDTO.getReceiptDate());
        this.setCustomerName(updateOrderDTO.getCustomerName());
        this.setCustomerSurname(updateOrderDTO.getCustomerSurname());
        this.setCustomerCompany(updateOrderDTO.getCustomerCompany());
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    public void addOrderItems(List<OrderItem> orderItems) {
        removeAllOrderItems();
        orderItems.forEach(it -> addOrderItem(it));
    }

    private void removeAllOrderItems() {
        this.getOrderItems().clear();
    }

    public void deleteOrderItem(OrderItem orderItem) {
        this.orderItems.remove(orderItem);
    }
}
