package com.microservicio_pedido.controller.DTO;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PedidoProductoDTO {
    private int idPedidoProducto;
    private int idProducto;
    private Integer cantidad;
    private float precioUnitario;
    private int idPedido;
}
