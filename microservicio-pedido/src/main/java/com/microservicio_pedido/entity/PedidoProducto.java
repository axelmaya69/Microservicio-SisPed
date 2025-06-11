package com.microservicio_pedido.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class PedidoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //PK
    private int idPedidoProducto;

    //FK
    private int idProducto;

    private Integer cantidad;

    private float precioUnitario;

    // Relación física interna con Pedido
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

}
