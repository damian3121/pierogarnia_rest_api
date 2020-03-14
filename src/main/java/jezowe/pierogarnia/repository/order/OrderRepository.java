package jezowe.pierogarnia.repository.order;

import jezowe.pierogarnia.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);

    Optional<Order> findByReceiptDateAndCustomerSurname(LocalDateTime orderDate, String customerSurname);

    boolean existsById(Long id);
}
