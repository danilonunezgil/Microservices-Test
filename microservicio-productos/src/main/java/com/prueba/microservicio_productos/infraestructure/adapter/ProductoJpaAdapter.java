package com.prueba.microservicio_productos.infraestructure.adapter;

import com.prueba.microservicio_productos.domain.model.Producto;
import com.prueba.microservicio_productos.domain.port.ProductoPersistencePort;
import com.prueba.microservicio_productos.infraestructure.adapter.entity.ProductoEntity;
import com.prueba.microservicio_productos.infraestructure.adapter.mapper.PrecioEntityMapper;
import com.prueba.microservicio_productos.infraestructure.adapter.mapper.ProductoEntityMapper;
import com.prueba.microservicio_productos.infraestructure.adapter.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ProductoJpaAdapter implements ProductoPersistencePort {
    private final ProductoRepository productoRepository;
    private final ProductoEntityMapper productoEntityMapper;
    private final PrecioEntityMapper precioEntityMapper;


    public ProductoJpaAdapter(ProductoRepository productoRepository, ProductoEntityMapper productoEntityMapper, PrecioEntityMapper precioEntityMapper) {
        this.productoRepository = productoRepository;
        this.productoEntityMapper = productoEntityMapper;
        this.precioEntityMapper = precioEntityMapper;
    }

    @Override
    public Producto crear(Producto producto) {
        ProductoEntity entity = productoEntityMapper.toEntity(producto);
        ProductoEntity guardado = productoRepository.save(entity);
        return productoEntityMapper.toDomain(guardado);
    }

    @Override
    public Producto obtenerPorID(Long id) {
        return productoRepository.findById(id)
                .map(productoEntityMapper::toDomain)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con ID: " + id));
    }

    @Override
    public Producto actualizarPorID(Long id, Producto producto) {
        ProductoEntity existente = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con ID: " + id));

        existente.setNombre(producto.getNombre());
        existente.setPrecio(precioEntityMapper.toEntity(producto.getPrecio()));

        ProductoEntity actualizado = productoRepository.save(existente);
        return productoEntityMapper.toDomain(actualizado);
    }

    @Override
    public boolean eliminarPorID(Long id) {
        if (!productoRepository.existsById(id)) {
            return false;
        }
        productoRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll().stream()
                .map(productoEntityMapper::toDomain)
                .toList();
    }
}
