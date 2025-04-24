package com.prueba.microservicio_productos.infraestructure.adapter.repository;

import com.prueba.microservicio_productos.infraestructure.adapter.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
}
