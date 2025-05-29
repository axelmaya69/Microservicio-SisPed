package com.microservicio_pedido.repository;

import com.microservicio_pedido.entity.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoProducto  extends JpaRepository<PedidoProducto,Integer> {
}
