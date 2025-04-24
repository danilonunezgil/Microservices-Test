package com.prueba.microservicio_productos.domain.model.dto.response;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private PrecioDTO precio;

    public ProductoDTO() {}

    public ProductoDTO(Long id, String nombre, PrecioDTO precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PrecioDTO getPrecio() {
        return precio;
    }

    public void setPrecio(PrecioDTO precio) {
        this.precio = precio;
    }
}
