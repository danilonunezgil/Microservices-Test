package com.prueba.microservicio_productos.infraestructure.rest.controller;

import com.prueba.microservicio_productos.application.usecases.ProductoUseCase;
import com.prueba.microservicio_productos.domain.model.dto.request.ProductoRequest;
import com.prueba.microservicio_productos.domain.model.dto.response.ProductoDTO;
import com.prueba.microservicio_productos.infraestructure.adapter.exception.ResourceNotFoundException;
import com.prueba.microservicio_productos.infraestructure.adapter.mapper.ApiResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    private final ProductoUseCase productoUseCase;

    public ProductoController(ProductoUseCase productoUseCase) {
        this.productoUseCase = productoUseCase;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponseMapper<ProductoDTO>> crearProducto(@RequestBody ProductoRequest productoRequest) {
        ProductoDTO productoDTO = productoUseCase.crear(productoRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponseMapper<>("Producto creado con éxito", true, 201, productoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseMapper<ProductoDTO>> obtenerProducto(@PathVariable Long id) {
        ProductoDTO productoDTO = productoUseCase.obtenerPorID(id);
        return ResponseEntity.ok(new ApiResponseMapper<>("Producto encontrado", true, 200, productoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseMapper<ProductoDTO>> actualizarProducto(@PathVariable Long id, @RequestBody ProductoRequest productoRequest) {
        ProductoDTO productoDTO = productoUseCase.actualizarPorID(id, productoRequest);
        return ResponseEntity.ok(new ApiResponseMapper<>("Producto actualizado con éxito", true, 200, productoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseMapper<Void>> eliminarProducto(@PathVariable Long id) {
        boolean eliminado = productoUseCase.eliminarPorID(id);
        if (!eliminado) {
            throw new ResourceNotFoundException("Producto con ID " + id + " no encontrado para eliminar");
        }
        return ResponseEntity.ok(new ApiResponseMapper<>("Producto eliminado con éxito", true, 200, null));
    }


    @GetMapping
    public ResponseEntity<ApiResponseMapper<List<ProductoDTO>>> listarProductos() {
        List<ProductoDTO> productosDTO = productoUseCase.obtenerTodos();
        return ResponseEntity.ok(new ApiResponseMapper<>("Productos listados con éxito", true, 200, productosDTO));
    }
}
