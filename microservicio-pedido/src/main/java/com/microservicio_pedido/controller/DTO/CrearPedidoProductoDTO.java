package com.microservicio_pedido.controller.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CrearPedidoProductoDTO {

    private int idProducto;

    private Integer cantidad;

}
