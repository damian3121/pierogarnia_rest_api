package invoices.integration.service.product;

import invoices.integration.RestTemplateProvider;
import invoices.integration.dto.product.FktProductDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FktProductServiceImpl implements FktProductService {
    private final RestTemplateProvider restTemplateProvider;

    public FktProductServiceImpl(RestTemplateProvider restTemplateProvider) {
        this.restTemplateProvider = restTemplateProvider;
    }

    public List<FktProductDTO> getAll() {
        String url = "https://o23523.fakturownia.pl/products.json?api_token=S2kbTzpKSlz5iIcu8S/o23523&page=1";
        List<FktProductDTO> products = Arrays.asList(restTemplateProvider.restTemplate().getForObject(url, FktProductDTO[].class));

        return products;
    }
}
