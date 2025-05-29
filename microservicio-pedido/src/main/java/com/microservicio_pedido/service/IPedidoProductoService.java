package com.microservicio_pedido.service;

import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.entity.PedidoProducto;

import java.util.List;

public interface IPedidoProductoService {

    PedidoProducto crearPedidoProducto(PedidoProducto pedidoProducto);

    PedidoProducto obtenerPedidoProducto(int idPedidoProducto);

    List<PedidoProducto> obtenerPedidosProductos();

    PedidoProducto editarPedidoProducto(int idPedidoProducto, PedidoProducto pedidoProducto);

    void eliminarPedidoProducto(int idPedidoProducto);

}
