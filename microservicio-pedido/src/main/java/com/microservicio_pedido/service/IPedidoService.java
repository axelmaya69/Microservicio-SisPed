package com.microservicio_pedido.service;

import com.microservicio_pedido.entity.Pedido;

import java.util.List;

public interface IPedidoService {

    Pedido crearPedido(Pedido pedido);

    Pedido obtenerPedido(int idPedido);

    List<Pedido> obtenerPedidos();

    Pedido editarPedido(int idPedido, Pedido pedido);

    void eliminarPedido(int idPedido);
}
