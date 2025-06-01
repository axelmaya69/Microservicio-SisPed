package com.microservicio_pedido.controller.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {
    private int idCliente;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String email;
}
