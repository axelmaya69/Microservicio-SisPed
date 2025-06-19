package com.microservicio_pedido.clientes;


import com.microservicio_pedido.DTO.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//Feign hacia el microservicio cliente
@FeignClient(name = "microservicio-cliente",url = "http://localhost:8080/api/cliente")
public interface IClienteFeignCliente {

    //Endpoint que devuelve a un cliente
    @GetMapping("get/{id}")
    ClienteDTO getClientById(@PathVariable int id);

}
