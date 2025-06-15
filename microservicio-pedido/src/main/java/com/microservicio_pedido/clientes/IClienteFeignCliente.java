package com.microservicio_pedido.clientes;


import com.microservicio_pedido.DTO.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-cliente",url = "http://localhost:8080/api/cliente")
public interface IClienteFeignCliente {

    @GetMapping("get/{id}")
    ClienteDTO getClientById(@PathVariable int id);

}
