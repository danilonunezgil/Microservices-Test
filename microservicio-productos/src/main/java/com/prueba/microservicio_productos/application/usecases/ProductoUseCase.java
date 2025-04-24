package com.prueba.microservicio_productos.application.usecases;

import com.prueba.microservicio_productos.domain.model.Producto;
import com.prueba.microservicio_productos.domain.model.dto.request.ProductoRequest;
import com.prueba.microservicio_productos.domain.model.dto.response.ProductoDTO;

import java.util.List;

public interface ProductoUseCase {
    ProductoDTO crear(ProductoRequest productoRequest);
    ProductoDTO obtenerPorID(Long id);
    ProductoDTO actualizarPorID(Long id, ProductoRequest productoRequest);
    boolean eliminarPorID(Long id);
    List<ProductoDTO> obtenerTodos();
}
