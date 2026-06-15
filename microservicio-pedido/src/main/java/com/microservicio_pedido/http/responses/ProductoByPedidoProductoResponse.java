package com.microservicio_pedido.http.responses;

import com.microservicio_pedido.DTO.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Getter
@Setter
public class ProductoByPedidoProductoResponse {

  private int idPedido;

  private ClienteDTO cliente;

  private List<ProductoDetalleDTO> productos;

  private LocalDate fecha;

  private float total;


}
