package com.prueba.microservicio_productos.domain.model.dto.response;

import java.math.BigDecimal;

public class PrecioDTO {
    private BigDecimal monto;

    public PrecioDTO() {}

    public PrecioDTO(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
