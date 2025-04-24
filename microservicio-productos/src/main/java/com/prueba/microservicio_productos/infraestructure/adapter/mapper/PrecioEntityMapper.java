package com.prueba.microservicio_productos.infraestructure.adapter.mapper;

import com.prueba.microservicio_productos.domain.model.Precio;
import com.prueba.microservicio_productos.infraestructure.adapter.entity.PrecioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrecioEntityMapper {
    PrecioEntity toEntity(Precio precio);
    Precio toDomain(PrecioEntity precioEntity);
}
