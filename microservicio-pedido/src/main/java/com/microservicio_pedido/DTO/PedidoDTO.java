package com.microservicio_pedido.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class PedidoDTO{

private int idPedido;

private int idCliente;

private LocalDate fecha;

private List<ProductoDTO> productos;

}
