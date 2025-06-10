package com.microservicio_pedido.cliente;


import com.microservicio_pedido.controller.DTO.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservicio-cliente",url = "http://localhost:8080/api/cliente")
public interface ICliente {

    @GetMapping("get/{id}")
    ClienteDTO getClientById(@PathVariable int id);
}
