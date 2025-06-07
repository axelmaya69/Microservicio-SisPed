package com.microservicio_pedido.service;

import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.http.responses.ClienteByPedidoResponse;

import java.util.List;

public interface IPedidoService {

    Pedido crearPedido(Pedido pedido);

    Pedido obtenerPedido(int idPedido);

    ClienteByPedidoResponse findClientesByIdPedido(int id);

    List<Pedido> obtenerPedidos();

    Pedido editarPedido(int idPedido, Pedido pedido);

    void eliminarPedido(int idPedido);
}
