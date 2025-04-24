package com.prueba.microservicio_productos.domain.services;

import com.prueba.microservicio_productos.application.mappers.PrecioResponseMapper;
import com.prueba.microservicio_productos.application.mappers.ProductoRequestMapper;
import com.prueba.microservicio_productos.application.mappers.ProductoResponseMapper;
import com.prueba.microservicio_productos.application.usecases.ProductoUseCase;
import com.prueba.microservicio_productos.domain.model.Producto;
import com.prueba.microservicio_productos.domain.model.dto.request.ProductoRequest;
import com.prueba.microservicio_productos.domain.model.dto.response.ProductoDTO;
import com.prueba.microservicio_productos.domain.port.ProductoPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements ProductoUseCase {
    private final ProductoPersistencePort productoPersistencePort;
    private final ProductoRequestMapper productoRequestMapper;
    private final ProductoResponseMapper productoResponseMapper;
    private final PrecioResponseMapper precioResponseMapper;


    public ProductoService(ProductoPersistencePort productoPersistencePort, ProductoRequestMapper productoRequestMapper, ProductoResponseMapper productoResponseMapper, PrecioResponseMapper precioResponseMapper) {
        this.productoPersistencePort = productoPersistencePort;
        this.productoRequestMapper = productoRequestMapper;
        this.productoResponseMapper = productoResponseMapper;
        this.precioResponseMapper = precioResponseMapper;
    }

    @Override
    public ProductoDTO crear(ProductoRequest productoRequest) {
        Producto producto = productoRequestMapper.toDomain(productoRequest);
        Producto creado = productoPersistencePort.crear(producto);
        return productoResponseMapper.toDTO(creado);    }

    @Override
    public ProductoDTO obtenerPorID(Long id) {
        Producto producto = productoPersistencePort.obtenerPorID(id);
        return productoResponseMapper.toDTO(producto);
    }

    @Override
    public ProductoDTO actualizarPorID(Long id, ProductoRequest productoRequest) {
        Producto producto = productoRequestMapper.toDomain(productoRequest);
        Producto actualizado = productoPersistencePort.actualizarPorID(id, producto);
        return productoResponseMapper.toDTO(actualizado);
    }

    @Override
    public boolean eliminarPorID(Long id) {
        return productoPersistencePort.eliminarPorID(id);
    }

    @Override
    public List<ProductoDTO> obtenerTodos() {
        List<Producto> productos = productoPersistencePort.obtenerTodos();
        return productoResponseMapper.toDTOList(productos);
    }
}
