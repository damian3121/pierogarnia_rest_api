package jezowe.pierogarnia.controller.product;

import jezowe.pierogarnia.dto.product.ProductDTO;
import jezowe.pierogarnia.model.product.Product;
import jezowe.pierogarnia.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> listProducts() {

        return productService.findAll();
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getOne(@PathVariable(value = "id") Long id) {

        return productService.findById(id);
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public Product saveProduct(@RequestBody ProductDTO productDTO) {

        return productService.save(productDTO);
    }

    @RequestMapping(value = "/update-product", method = RequestMethod.POST)
    public Product updateProduct(@RequestBody ProductDTO productDTO) {

        return productService.update(productDTO);
    }
}
