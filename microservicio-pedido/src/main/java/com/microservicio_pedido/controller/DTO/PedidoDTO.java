package com.microservicio_pedido.controller.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PedidoDTO{

private int idPedido;

private int idCliente;

private LocalDate fecha;

}
