package com.prueba.microservicio_productos.application.mappers;

import com.prueba.microservicio_productos.domain.model.Producto;
import com.prueba.microservicio_productos.domain.model.dto.response.ProductoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoResponseMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "precio", target = "precio")
    ProductoDTO toDTO(Producto producto);

    List<ProductoDTO> toDTOList(List<Producto> productos);
}
