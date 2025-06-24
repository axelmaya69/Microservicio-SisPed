package com.microservicio_pedido.DTO;

import com.microservicio_pedido.entity.PedidoProducto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class PedidoProductoDTO {

    private int idProducto;

    private int pedidoId;

    private Integer cantidad;

    private float precioUnitario;


    public PedidoProductoDTO(PedidoProducto entidad) {
        this.idProducto = entidad.getIdProducto();
        this.cantidad = entidad.getCantidad();
        this.precioUnitario = entidad.getPrecioUnitario();
        this.pedidoId = entidad.getPedido().getIdPedido();
    }

}
