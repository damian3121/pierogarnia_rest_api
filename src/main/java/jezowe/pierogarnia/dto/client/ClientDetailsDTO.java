package jezowe.pierogarnia.dto.client;

import lombok.Data;

@Data
public class ClientDetailsDTO {
    private Long fktCustomerId;
    private String extraInfoClientName;
    private String extraInfo;
}
