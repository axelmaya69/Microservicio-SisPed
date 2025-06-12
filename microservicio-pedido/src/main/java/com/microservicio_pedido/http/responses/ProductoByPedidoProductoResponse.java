package com.microservicio_pedido.http.responses;

import com.microservicio_pedido.controller.DTO.ClienteDTO;
import com.microservicio_pedido.controller.DTO.ProductoDTO;
import com.microservicio_pedido.entity.Pedido;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@Getter
@Setter
public class ProductoByPedidoProductoResponse {

    private int idPedidoProducto;

    private int idProducto;

    private Integer cantidad;

    private float precioUnitario;

    private int idPedido;

    private List<ProductoDTO> productoDTO;
}
