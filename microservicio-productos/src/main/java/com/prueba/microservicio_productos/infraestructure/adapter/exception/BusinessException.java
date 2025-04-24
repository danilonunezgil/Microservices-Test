package com.prueba.microservicio_productos.infraestructure.adapter.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
