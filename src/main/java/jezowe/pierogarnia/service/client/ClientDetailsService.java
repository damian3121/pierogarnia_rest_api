package jezowe.pierogarnia.service.client;

import jezowe.pierogarnia.dto.client.ClientDetailsDTO;
import jezowe.pierogarnia.model.client.ClientDetails;

import java.util.List;

public interface ClientDetailsService {
    ClientDetails create(ClientDetailsDTO clientDetailsDTO);

    ClientDetails update(Long id, ClientDetailsDTO clientDetailsDTO);

    void delete(Long id);

    List<ClientDetails> findAll();

    ClientDetails findById(Long id);

    ClientDetails findByExtraInfoClientName(String name);
}
