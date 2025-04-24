package com.prueba.microservicio_productos.domain.model.dto.request;

import java.math.BigDecimal;

public class ProductoRequest {
    private String nombre;
    private BigDecimal precio;

    public ProductoRequest(String nombre, BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProductoRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
