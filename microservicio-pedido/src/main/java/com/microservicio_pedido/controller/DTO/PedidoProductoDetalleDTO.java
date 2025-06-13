package com.microservicio_pedido.controller.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class PedidoProductoDetalleDTO {
    private int idPedido;
    private LocalDate fecha;

    private ClienteDTO cliente;

    private List<PedidoProductoDTO> productos;
}
