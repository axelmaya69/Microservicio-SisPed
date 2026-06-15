package com.microservicio_pedido.service;

import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.http.responses.ClienteByPedidoResponse;
import com.microservicio_pedido.http.responses.ProductoByPedidoProductoResponse;

import java.util.List;

public interface IPedidoService {

    Pedido crearPedido(Pedido pedido);

    Pedido obtenerPedido(int idPedido);

    ClienteByPedidoResponse obtenerPedidosPorCliente(int clienteId);

    ProductoByPedidoProductoResponse obtenerProductosByIdPedido(int id);

    List<Pedido> obtenerPedidos();

    Pedido editarPedido(int idPedido, Pedido pedido);

    void eliminarPedido(int idPedido);
}
