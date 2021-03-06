package jezowe.pierogarnia.controller.product;

import invoices.integration.dto.product.FktProductDTO;
import invoices.integration.service.product.FktProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/fkt-products")
@RestController
public class FktProductController {
    private final FktProductService fktProductService;

    public FktProductController(FktProductService fktProductService) {
        this.fktProductService = fktProductService;
    }

    @GetMapping
    public List<FktProductDTO> getAll() {
        return fktProductService.getAll();
    }
}
