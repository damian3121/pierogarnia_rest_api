package invoices.integration.service.client;

import invoices.integration.RestTemplateProvider;
import invoices.integration.dto.client.FktClientDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FktClientServiceImpl implements FktClientService {
    private final RestTemplateProvider restTemplateProvider;

    public FktClientServiceImpl(RestTemplateProvider restTemplateProvider) {
        this.restTemplateProvider = restTemplateProvider;
    }

    public List<FktClientDTO> getAll() {
        String url = "https://o23523.fakturownia.pl/clients.json?api_token=S2kbTzpKSlz5iIcu8S/o23523&page=1";
        List<FktClientDTO> clients = Arrays.asList(restTemplateProvider.restTemplate().getForObject(url, FktClientDTO[].class));

        return clients;
    }
}
