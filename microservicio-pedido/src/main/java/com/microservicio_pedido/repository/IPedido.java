package com.microservicio_pedido.repository;

import com.microservicio_pedido.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedido  extends JpaRepository<Pedido, Integer> {

}
