package jezowe.pierogarnia.repository.order;

import jezowe.pierogarnia.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Optional<OrderItem> findById(Long id);

    boolean existsById(Long id);
}
