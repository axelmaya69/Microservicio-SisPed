package com.microservicio_pedido.cliente;

import com.microservicio_pedido.controller.DTO.PedidoDTO;
import com.microservicio_pedido.controller.DTO.PedidoProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-cliente",url = "localhost:9090/api/cliente")
public interface IClientePedidoProducto {

    /*
    @GetMapping("search-my-pedidoproduct/{idPedidoProducto}")
    List<PedidoDTO> findAllClientsByPedidoProducto(@PathVariable int id);
     */

    @GetMapping("/pedido-producto/pedido/{idPedido}")
    List<PedidoProductoDTO> obtenerPorPedido(@PathVariable int idPedido);
}
