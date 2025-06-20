package com.microservicio_pedido.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductoDetalleDTO {

    private int idProducto;

    private String nombre;

    private float precio;

    private int cantidad;

    private float precioUnitario;


}
