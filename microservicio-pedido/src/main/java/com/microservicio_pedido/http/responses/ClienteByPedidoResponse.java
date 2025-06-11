package com.microservicio_pedido.http.responses;

import com.microservicio_pedido.controller.DTO.ClienteDTO;
import com.microservicio_pedido.controller.DTO.ProductoDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ClienteByPedidoResponse {

    private int idPedido;

    private LocalDate fecha;

    private int idCliente;

    private ClienteDTO clienteDTO;

    private List<ProductoDTO> productoDTO;
}
