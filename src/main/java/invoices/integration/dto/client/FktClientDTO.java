package invoices.integration.dto.client;

import lombok.Data;

@Data
public class FktClientDTO {
    private Long id;
    private String name;
    private String tax_no;
    private String shortcut;
}
