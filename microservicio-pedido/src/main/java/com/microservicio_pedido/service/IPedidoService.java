package com.microservicio_pedido.service;

import com.microservicio_pedido.controller.DTO.PedidoDetalleDTO;
import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.http.responses.ClienteByPedidoResponse;

import java.util.List;

public interface IPedidoService {

    Pedido crearPedido(Pedido pedido);

    Pedido obtenerPedido(int idPedido);

    ClienteByPedidoResponse obtenerPedidosPorCliente(int clienteId);


    List<Pedido> obtenerPedidos();

    Pedido editarPedido(int idPedido, Pedido pedido);

    void eliminarPedido(int idPedido);
}
