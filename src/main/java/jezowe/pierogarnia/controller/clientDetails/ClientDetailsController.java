package jezowe.pierogarnia.controller.clientDetails;

import jezowe.pierogarnia.dto.client.ClientDetailsDTO;
import jezowe.pierogarnia.model.client.ClientDetails;
import jezowe.pierogarnia.repository.client.ClientDetailsRepository;
import jezowe.pierogarnia.service.client.ClientDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/client-details")
@RestController
public class ClientDetailsController {
    private final ClientDetailsService clientDetailsService;
    private final ClientDetailsRepository clientDetailsRepository;

    public ClientDetailsController(ClientDetailsService clientDetailsService, ClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsService = clientDetailsService;
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @PostMapping
    public ClientDetails create(@RequestBody ClientDetailsDTO clientDetailsDTO) {
        return clientDetailsService.create(clientDetailsDTO);
    }

    @GetMapping
    public List<ClientDetails> clientDetails() {
        return clientDetailsService.findAll();
    }

    @GetMapping(value = "/name/{extraInfoClientName}")
    public ClientDetails getByExtraInfoClientName(@PathVariable(value = "extraInfoClientName") String extraInfoClientName) {
        return clientDetailsService.findByExtraInfoClientName(extraInfoClientName);
    }

    @GetMapping(value = "/{id}")
    public ClientDetails getById(@PathVariable(value = "id") Long id) {
        return clientDetailsService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public ClientDetails update(@PathVariable(value = "id") Long id, @RequestBody ClientDetailsDTO clientDetailsDTO) {
        return clientDetailsService.update(id, clientDetailsDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        clientDetailsService.delete(id);
    }
}
