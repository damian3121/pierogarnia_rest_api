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
    public Product create(ProductDTO productDTO) {
        Product newProduct = new Product();
        newProduct.setName(productDTO.getName());
        newProduct.setPrice(productDTO.getPrice());
        return productDAO.save(newProduct);
    }

    @Override
    public Product update(ProductDTO productDTO) {
        Product updatedProduct = productDAO.getOne(productDTO.getId());
        updatedProduct.setName(productDTO.getName());
        updatedProduct.setPrice(productDTO.getPrice());

        return productDAO.save(updatedProduct);
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

    @Override
    public void delete(Long id) {
        productDAO.deleteById(id);
    }
}
