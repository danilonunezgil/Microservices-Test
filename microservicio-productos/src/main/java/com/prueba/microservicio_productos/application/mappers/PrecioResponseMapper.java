package com.prueba.microservicio_productos.application.mappers;

import com.prueba.microservicio_productos.domain.model.Precio;
import com.prueba.microservicio_productos.domain.model.dto.response.PrecioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PrecioResponseMapper {
    @Mapping(source = "monto", target = "monto")
    PrecioDTO toDTO(Precio precio);
}
