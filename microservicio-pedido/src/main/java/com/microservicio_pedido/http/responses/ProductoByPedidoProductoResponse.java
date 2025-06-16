package com.microservicio_pedido.http.responses;

import com.microservicio_pedido.DTO.ClienteDTO;
import com.microservicio_pedido.DTO.PedidoDTO;
import com.microservicio_pedido.DTO.PedidoProductoDTO;
import com.microservicio_pedido.DTO.ProductoDTO;
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

  private ClienteDTO clienteDTO;

  private PedidoProductoDTO pedidoProductoDTO;

  private List<ProductoDTO> productos;


}
