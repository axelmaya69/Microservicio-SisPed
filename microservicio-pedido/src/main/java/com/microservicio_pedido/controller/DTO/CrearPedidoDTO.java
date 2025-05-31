package com.microservicio_pedido.controller.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Setter
@Getter
public class CrearPedidoDTO {

    private int idCliente;

    private LocalDate fecha;
}
