package com.microservicio_pedido.controller.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductoDTO {

    private int idProducto;

    private String nombre;

    private String descripcion;

    private float precio;
}
