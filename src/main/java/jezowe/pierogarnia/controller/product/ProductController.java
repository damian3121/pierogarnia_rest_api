package jezowe.pierogarnia.controller.product;

import jezowe.pierogarnia.dto.product.ProductDTO;
import jezowe.pierogarnia.model.product.Product;
import jezowe.pierogarnia.repository.product.ProductRepository;
import jezowe.pierogarnia.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/products")
@RestController
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product create(@RequestBody ProductDTO productDTO) {

        return productService.create(productDTO);
    }

    @GetMapping
    public List<Product> products() {

        return productService.findAll();
    }

    @GetMapping(value = "/name/{name}")
    public Product getByName(@PathVariable(value = "name") String name) {

        return productService.findByName(name);
    }

    @GetMapping(value = "/{id}")
    public Product getById(@PathVariable(value = "id") Long id) {

        return productService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public Product update(@PathVariable(value = "id") Long id, @RequestBody ProductDTO productDTO) {

        return productService.update(id, productDTO);
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        productService.delete(id);
    }
}
