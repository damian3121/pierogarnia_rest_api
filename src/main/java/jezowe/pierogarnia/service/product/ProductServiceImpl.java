package jezowe.pierogarnia.service.product;

import jezowe.pierogarnia.dao.product.ProductDAO;
import jezowe.pierogarnia.dto.product.ProductDTO;
import jezowe.pierogarnia.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public Product save(ProductDTO productDTO) {
        Product newProduct = new Product();
        newProduct.setName(productDTO.getName());
        newProduct.setPrice(productDTO.getPrice());

        return productDAO.save(newProduct);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDAO.findById(id).get();
    }

    @Override
    public Product findByName(String name) {
        return productDAO.findByName(name);
    }
}
