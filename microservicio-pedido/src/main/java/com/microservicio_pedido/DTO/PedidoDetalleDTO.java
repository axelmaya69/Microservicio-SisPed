package com.microservicio_pedido.controller.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class PedidoDetalleDTO {

    private ClienteDTO cliente;



}
