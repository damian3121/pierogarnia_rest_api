package jezowe.pierogarnia.repository.product;

import jezowe.pierogarnia.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    Product findByName(String name);

    boolean existsByName(String name);

    boolean existsById(Long id);
}
