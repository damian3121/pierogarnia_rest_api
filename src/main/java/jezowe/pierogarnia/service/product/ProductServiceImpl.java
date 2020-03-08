package jezowe.pierogarnia.service.product;

import jezowe.pierogarnia.dto.product.ProductDTO;
import jezowe.pierogarnia.exception.CanNotFindResourceProblem;
import jezowe.pierogarnia.exception.DuplicateProblem;
import jezowe.pierogarnia.mapper.product.ProductMapper;
import jezowe.pierogarnia.model.product.Product;
import jezowe.pierogarnia.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(ProductDTO productDTO) {
        if (checkIfProductExistByName(productDTO.getName())) {
            throw new DuplicateProblem("Product already exist: " + productDTO.getName());
        }

        Product addedProduct = ProductMapper.INSTANCE.toProduct(productDTO);
        return productRepository.save(addedProduct);
    }

    @Override
    public Product update(Long id, ProductDTO productDTO) {
        if (!checkIfProductExistById(productDTO.getId())) {
            throw new CanNotFindResourceProblem("Resource not exist: " + productDTO.getName());
        }

        Product updatedProduct = ProductMapper.INSTANCE.toProduct(productDTO);
        updatedProduct.setId(id);

        return productRepository.save(updatedProduct);
    }

    @Override
    public void delete(Long id) {
        if (!checkIfProductExistById(id)) {
            throw new CanNotFindResourceProblem("Resource not exist (product id): " + id);
        }

        productRepository.deleteById(id);
    }

    private boolean checkIfProductExistByName(String name) {
        return productRepository.existsByName(name);
    }

    private boolean checkIfProductExistById(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
