package jezowe.pierogarnia.dao.product;

import jezowe.pierogarnia.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    Product findByName(String name);
}
