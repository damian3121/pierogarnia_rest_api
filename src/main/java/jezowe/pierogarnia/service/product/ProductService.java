package jezowe.pierogarnia.service.product;

import jezowe.pierogarnia.dto.product.ProductDTO;
import jezowe.pierogarnia.model.product.Product;

import java.util.List;

public interface ProductService {
    Product create(ProductDTO productDTO);

    Product update(ProductDTO productDTO);

    void delete(Long id);

    List<Product> findAll();

    Product findById(Long id);

    Product findByName(String name);
}
