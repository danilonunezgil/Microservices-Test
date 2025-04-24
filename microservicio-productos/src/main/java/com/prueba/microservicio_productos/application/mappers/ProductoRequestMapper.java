package com.prueba.microservicio_productos.application.mappers;

import com.prueba.microservicio_productos.domain.model.Producto;
import com.prueba.microservicio_productos.domain.model.dto.request.ProductoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoRequestMapper {
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "precio", target = "precio.monto")
    Producto toDomain(ProductoRequest request);
}
