package com.microservicio_pedido.service;

import com.microservicio_pedido.DTO.PedidoProductoDTO;
import com.microservicio_pedido.entity.PedidoProducto;
import com.microservicio_pedido.http.responses.ProductoByPedidoProductoResponse;

import java.util.List;

public interface IPedidoProductoService {

    PedidoProducto crearPedidoProducto(PedidoProducto pedidoProducto);

    PedidoProductoDTO obtenerPedidoProducto(int idPedidoProducto);

    //ProductoByPedidoProductoResponse obtenerProductosByIdPedido(int id);

    List<PedidoProductoDTO> obtenerPedidosProductos();

    PedidoProducto editarPedidoProducto(int idPedidoProducto, PedidoProducto pedidoProducto);

    void eliminarPedidoProducto(int idPedidoProducto);

}
