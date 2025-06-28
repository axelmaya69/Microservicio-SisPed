package com.microservicio_cliente.repository;


import com.microservicio_cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICliente extends JpaRepository<Cliente, Integer> {

}
