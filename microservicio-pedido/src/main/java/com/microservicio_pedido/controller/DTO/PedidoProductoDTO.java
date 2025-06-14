package com.microservicio_pedido.controller.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PedidoProductoDTO {

    private int idPedidoProducto;

    private int idProducto;

    private int pedidoId;

    private Integer cantidad;

    private float precioUnitario;


}
