package com.microservicio_pedido.service;

import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.http.response.ClienteByPedidoResponse;

import java.util.List;

public interface IPedidoService {

    Pedido crearPedido(Pedido pedido);

    Pedido obtenerPedido(int idPedido);

    List<Pedido> obtenerPedidos();

    //ClienteByPedidoResponse findClientesByIdPedidos(int id);

    Pedido editarPedido(int idPedido, Pedido pedido);

    void eliminarPedido(int idPedido);
}
