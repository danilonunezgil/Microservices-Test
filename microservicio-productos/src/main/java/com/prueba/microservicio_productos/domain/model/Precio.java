package com.prueba.microservicio_productos.domain.model;

import java.math.BigDecimal;

public class Precio {
    private BigDecimal monto;

    public Precio(BigDecimal monto) {
        if(monto == null) throw new IllegalArgumentException("Precio es nulo");
        if(monto.scale() > 2) throw new IllegalArgumentException("Máximo 2 decimales");
        if (monto.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("El Precio no puede ser negativo.");
    }

    public Precio() {
    }

    public Precio add(Precio aumento) {
        return new Precio(this.monto.add(aumento.monto));
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
