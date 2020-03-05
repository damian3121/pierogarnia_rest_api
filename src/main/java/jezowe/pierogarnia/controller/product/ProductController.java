package jezowe.pierogarnia.controller.product;

import jezowe.pierogarnia.dto.product.ProductDTO;
import jezowe.pierogarnia.model.product.Product;
import jezowe.pierogarnia.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/products")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> productsList() {

        return productService.findAll();
    }

    @RequestMapping(
            value = "/{name}",
            method = RequestMethod.GET,
            produces = "application/jezowe.pierogarnia.controller.user.getbyname+json")
    public Product getByName(@PathVariable(value = "name") String name) {

        return productService.findByName(name);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = "application/jezowe.pierogarnia.controller.user.getbyid+json")
    public Product getProductById(@PathVariable(value = "id") Long id) {

        return productService.findById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Product create(@RequestBody ProductDTO productDTO) {

        return productService.create(productDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Product update(@RequestBody ProductDTO productDTO) {

        return productService.update(productDTO);
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        productService.delete(id);
    }
}
