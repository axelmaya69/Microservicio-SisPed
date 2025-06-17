package com.microservicio_pedido.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private int idPedidoProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    @JsonBackReference
    private Pedido pedido;

    private int idProducto;

    private Integer cantidad;

    private float precioUnitario;


}
