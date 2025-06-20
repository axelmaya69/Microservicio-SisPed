package com.microservicio_pedido.service;

import com.microservicio_pedido.DTO.PedidoProductoDTO;
import com.microservicio_pedido.entity.PedidoProducto;

import java.util.List;

public interface IPedidoProductoService {

    PedidoProducto crearPedidoProducto(PedidoProducto pedidoProducto);

    PedidoProductoDTO obtenerPedidoProducto(int idPedidoProducto);

    List<PedidoProductoDTO> obtenerPedidosProductos();

    PedidoProducto editarPedidoProducto(int idPedidoProducto, PedidoProducto pedidoProducto);

    void eliminarPedidoProducto(int idPedidoProducto);

}
