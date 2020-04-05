package jezowe.pierogarnia.service.client;

import jezowe.pierogarnia.dto.client.ClientDetailsDTO;
import jezowe.pierogarnia.exception.CanNotFindResourceProblem;
import jezowe.pierogarnia.exception.DuplicateProblem;
import jezowe.pierogarnia.mapper.client.ClientDetailsMapper;
import jezowe.pierogarnia.model.client.ClientDetails;
import jezowe.pierogarnia.repository.client.ClientDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {
    private final ClientDetailsRepository clientDetailsRepository;

    @Override
    public ClientDetails create(ClientDetailsDTO clientDetailsDTO) {
        if (checkIfExtraInfoClientNameExist(clientDetailsDTO.getExtraInfoClientName())) {
            throw new DuplicateProblem("Extra note already exist: " + clientDetailsDTO.getExtraInfoClientName());
        }

        ClientDetails addedClientDetails = ClientDetailsMapper.INSTANCE.toClientDetails(clientDetailsDTO);
        return clientDetailsRepository.save(addedClientDetails);
    }

    @Override
    public ClientDetails update(Long id, ClientDetailsDTO clientDetailsDTO) {
        if (!checkIfExtraInfoClientNameExist(clientDetailsDTO.getExtraInfoClientName())) {
            throw new DuplicateProblem("Extra note not exist: " + clientDetailsDTO.getExtraInfoClientName());
        }

        ClientDetails addedClientDetails = ClientDetailsMapper.INSTANCE.toClientDetails(clientDetailsDTO);

        return clientDetailsRepository.save(addedClientDetails);
    }

    @Override
    public void delete(Long id) {
        if (!checkIfExtraInfoClientNameById(id)) {
            throw new CanNotFindResourceProblem("Resource not exist (client extra note id): " + id);
        }

        clientDetailsRepository.deleteById(id);
    }

    @Override
    public List<ClientDetails> findAll() {
        return clientDetailsRepository.findAll();
    }

    @Override
    public ClientDetails findById(Long id) {
        return clientDetailsRepository.findById(id).orElseThrow(() ->
                new CanNotFindResourceProblem("Resource not exist (client extra note id): " + id));
    }

    @Override
    public ClientDetails findByExtraInfoClientName(String name) {
        return clientDetailsRepository.findByExtraInfoClientName(name);
    }

    private boolean checkIfExtraInfoClientNameExist(String extraInfoClientName) {
        return clientDetailsRepository.existsByExtraInfoClientName(extraInfoClientName);
    }

    private boolean checkIfExtraInfoClientNameById(Long id) {
        return clientDetailsRepository.existsById(id);
    }
}
