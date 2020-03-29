package invoices.integration.service.client;

import invoices.integration.dto.client.FktClientDTO;

import java.util.List;

public interface FktClientService {
    List<FktClientDTO> getAll();
}
