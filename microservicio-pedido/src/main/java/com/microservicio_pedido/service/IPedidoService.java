package com.microservicio_pedido.service;

import com.microservicio_pedido.controller.DTO.CrearPedidoDTO;
import com.microservicio_pedido.controller.DTO.PedidoDTO;
import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.http.response.ClienteByPedidoResponse;

import java.util.List;

public interface IPedidoService {

    PedidoDTO crearPedido(CrearPedidoDTO dto);

    /*
    @Override
    public Pedido crearPedido(Pedido pedido) {
        return iPedido.save(pedido);
    }
     */

    Pedido obtenerPedido(int idPedido);

    List<Pedido> obtenerPedidos();

    //ClienteByPedidoResponse findClientesByIdPedidos(int id);

    Pedido editarPedido(int idPedido, Pedido pedido);

    void eliminarPedido(int idPedido);
}
