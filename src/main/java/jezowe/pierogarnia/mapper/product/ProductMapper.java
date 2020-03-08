package jezowe.pierogarnia.mapper.product;

import jezowe.pierogarnia.dto.product.ProductDTO;
import jezowe.pierogarnia.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDTO productDTO);
}
