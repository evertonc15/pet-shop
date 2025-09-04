package evertonc15.com.github.pet_shop.mapper;

import evertonc15.com.github.pet_shop.dto.ProductDTO;
import evertonc15.com.github.pet_shop.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO entityToDto(Product product);

    Product dtoToEntity(ProductDTO productDTO);

}
