package com.prueba.microservicio_productos.infraestructure.adapter.mapper;

import com.prueba.microservicio_productos.domain.model.Producto;
import com.prueba.microservicio_productos.infraestructure.adapter.entity.ProductoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoEntityMapper {
    Producto toDomain(ProductoEntity entity);
    ProductoEntity toEntity(Producto domain);
}
