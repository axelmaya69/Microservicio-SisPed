package com.microservicio_pedido.cliente;


import com.microservicio_pedido.controller.DTO.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservicio-cliente",url = "httṕ://localhost:9090/api/cliente")
public interface ICliente {

    @GetMapping("search-my-pedido/{id}")
    List<ClienteDTO> findAllClientsByPedido(@PathVariable int id);
}
