package com.microservicio_pedido.http.responses;

import com.microservicio_pedido.controller.DTO.ClienteDTO;
import com.microservicio_pedido.controller.DTO.PedidoProductoDTO;
import com.microservicio_pedido.controller.DTO.ProductoDTO;
import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.entity.PedidoProducto;
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

  private List<PedidoProductoDTO> pedidoProducto;

    private List<ProductoDTO> productoDTO;
}
