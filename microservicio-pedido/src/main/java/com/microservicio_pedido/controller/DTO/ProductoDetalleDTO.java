package com.microservicio_pedido.controller.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductoDetalleDTO {

    private int idProducto;

    private String nombre;

    private String descripcion;

    private float precio; // Precio del producto según catálogo

    private int cantidad; // Cantidad solicitada en el pedido

    private float precioUnitario;
}
