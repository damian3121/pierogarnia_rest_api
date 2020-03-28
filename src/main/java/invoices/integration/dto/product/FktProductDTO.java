package invoices.integration.dto.product;

import lombok.Data;

@Data
public class FktProductDTO {
    private Long id;
    private String name;
    private String price_net;
    private String price_gross;
}
