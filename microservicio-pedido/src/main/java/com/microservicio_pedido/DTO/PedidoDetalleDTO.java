package com.microservicio_pedido.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PedidoDetalleDTO {

    private ClienteDTO cliente;



}
