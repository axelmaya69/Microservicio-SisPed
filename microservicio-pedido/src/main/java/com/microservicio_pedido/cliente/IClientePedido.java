package com.microservicio_pedido.cliente;

import com.microservicio_pedido.controller.DTO.PedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservicio-cliente",url = "localhost:8585/api/cliente")
public interface IClientePedido {

    /*@GetMapping("search-my-pedido/{idProducto}")
    List<PedidoDTO> findAllClientsByPedido(@PathVariable int id);

     */
}
