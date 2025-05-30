package com.microservicio_pedido.http.response;

import com.microservicio_pedido.controller.DTO.PedidoDTO;
import com.microservicio_pedido.entity.PedidoProducto;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public class ClienteByPedidoResponse {

    private int clienteId;

    private LocalDate fecha;

    private List<PedidoProducto> productos;

    private List <PedidoDTO> clienteDTOS;
}
