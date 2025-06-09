package com.microservicio_producto.repository;

import com.microservicio_producto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProducto extends JpaRepository<Producto,Integer> {
}
