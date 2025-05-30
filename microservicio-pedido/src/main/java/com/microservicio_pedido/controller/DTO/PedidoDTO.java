package com.microservicio_pedido.controller.DTO;

import lombok.Builder;

import java.time.LocalDate;

@Builder
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
