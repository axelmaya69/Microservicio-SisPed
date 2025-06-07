package com.microservicio_pedido.http.responses;

import com.microservicio_pedido.controller.DTO.ClienteDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ClienteByPedidoResponse {

    private int idCliente;

    private LocalDate fecha;

    private List<ClienteDTO> clienteDTO;
}
