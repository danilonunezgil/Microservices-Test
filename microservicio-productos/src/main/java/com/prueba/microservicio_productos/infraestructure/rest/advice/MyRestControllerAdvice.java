package com.prueba.microservicio_productos.infraestructure.rest.advice;

import com.prueba.microservicio_productos.infraestructure.adapter.exception.BusinessException;
import com.prueba.microservicio_productos.infraestructure.adapter.exception.ResourceNotFoundException;
import com.prueba.microservicio_productos.infraestructure.adapter.mapper.ApiResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyRestControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMapper<Void>> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponseMapper<>(ex.getMessage(), false, 404, null));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponseMapper<Void>> handleBusinessException(BusinessException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponseMapper<>(ex.getMessage(), false, 400, null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseMapper<Void>> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponseMapper<>("Error interno del servidor", false, 500, null));
    }
}
