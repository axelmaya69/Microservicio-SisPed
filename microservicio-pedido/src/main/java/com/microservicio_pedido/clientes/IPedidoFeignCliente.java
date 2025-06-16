package com.microservicio_pedido.clientes;

import com.microservicio_pedido.DTO.ClienteDTO;
import com.microservicio_pedido.DTO.PedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-pedido",url = "http://localhost:8080/api/pedidoproducto")
public interface IPedidoFeignCliente {


    @GetMapping("get/{id}")
    PedidoDTO getPedidotById(@PathVariable int id);

}
