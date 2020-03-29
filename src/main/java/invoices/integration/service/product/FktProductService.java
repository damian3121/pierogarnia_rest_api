package invoices.integration.service.product;

import invoices.integration.dto.product.FktProductDTO;

import java.util.List;

public interface FktProductService {
    List<FktProductDTO> getAll();
}
