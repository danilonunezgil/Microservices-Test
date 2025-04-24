package com.prueba.microservicio_productos.infraestructure.adapter.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponseMapper<T> {
    private String message;
    private boolean status;
    private int code;
    private T result;

}
