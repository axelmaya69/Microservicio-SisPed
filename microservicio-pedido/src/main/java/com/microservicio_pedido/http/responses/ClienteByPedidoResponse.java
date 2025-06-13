package com.microservicio_pedido.http.responses;

import com.microservicio_pedido.controller.DTO.ClienteDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClienteByPedidoResponse {

    private int idPedido;

    private LocalDate fecha;

    private int idCliente;

    private ClienteDTO clienteDTO;

}
