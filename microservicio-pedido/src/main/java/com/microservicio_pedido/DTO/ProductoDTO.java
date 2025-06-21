package com.microservicio_pedido.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductoDTO {

    private int idProducto;

    private String nombre;

    private String descripcion;

    private float precio;

}
