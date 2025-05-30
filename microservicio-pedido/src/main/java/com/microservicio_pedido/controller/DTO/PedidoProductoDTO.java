package com.microservicio_pedido.controller.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class PedidoProductoDTO {
    private int id;
    private int idPedido;
    private int idServicio;
    private int cantidad;
}
