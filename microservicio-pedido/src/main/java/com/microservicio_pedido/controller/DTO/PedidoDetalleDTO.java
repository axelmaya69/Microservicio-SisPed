package com.microservicio_pedido.controller.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class PedidoDetalleDTO {

    private int idPedido;

    private int idCliente;

    private LocalDate fecha;

    private ClienteDTO clienteDTO;

    private List<ProductoDetalleDTO> productos;
}
