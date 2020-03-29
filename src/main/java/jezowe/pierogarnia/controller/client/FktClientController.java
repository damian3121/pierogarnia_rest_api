package jezowe.pierogarnia.controller.client;

import invoices.integration.dto.client.FktClientDTO;
import invoices.integration.service.client.FktClientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/fkt-clients")
@RestController
public class FktClientController {
    private final FktClientService fktClientService;

    public FktClientController(FktClientService fktClientService) {
        this.fktClientService = fktClientService;
    }

    @GetMapping
    public List<FktClientDTO> getAll() {
        return fktClientService.getAll();
    }
}
