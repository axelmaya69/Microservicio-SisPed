package com.microservicio_pedido.controller.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class PedidoDTO {
/*    private int idCliente;

    private String nombre;

    private String apellidoP;

    private String apellidoM;

    private String email;

    */
    private int idPedido;

    private int idCliente;

    private LocalDate fecha;

}
