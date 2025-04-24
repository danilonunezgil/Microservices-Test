package com.prueba.microservicio_productos.domain.port;

import com.prueba.microservicio_productos.domain.model.Producto;

import java.util.List;

public interface ProductoPersistencePort {
    Producto crear(Producto producto);
    Producto obtenerPorID(Long id);
    Producto actualizarPorID(Long id, Producto producto);
    boolean eliminarPorID(Long id);
    List<Producto> obtenerTodos();
}
