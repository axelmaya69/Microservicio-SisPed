package com.microservicio_pedido.controller.DTO;

import com.microservicio_pedido.entity.PedidoProducto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.management.ConstructorParameters;

@Data
@Builder
@AllArgsConstructor
public class PedidoProductoDTO {

    private int idPedidoProducto;

    private int idProducto;

    private int pedidoId;

    private Integer cantidad;

    private float precioUnitario;

    public PedidoProductoDTO(PedidoProducto entidad) {
        this.idPedidoProducto = entidad.getIdPedidoProducto();
        this.idProducto = entidad.getIdProducto();
        this.cantidad = entidad.getCantidad();
        this.precioUnitario = entidad.getPrecioUnitario();
        this.pedidoId = entidad.getPedido().getIdPedido();
    }

}
