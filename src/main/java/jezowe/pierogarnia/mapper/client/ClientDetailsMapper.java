package jezowe.pierogarnia.mapper.client;

import jezowe.pierogarnia.dto.client.ClientDetailsDTO;
import jezowe.pierogarnia.model.client.ClientDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientDetailsMapper {
    ClientDetailsMapper INSTANCE = Mappers.getMapper(ClientDetailsMapper.class);
    
    @Mapping(target = "fktCustomerId", source = "fktCustomerId")
    @Mapping(target = "extraInfoClientName", source = "extraInfoClientName")
    @Mapping(target = "extraInfo", source = "extraInfo")
    ClientDetails toClientDetails(ClientDetailsDTO clientDetailsDTO);
}