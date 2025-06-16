package com.microservicio_pedido.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //PK
    private int idPedido;

    //FK
    private int idCliente;

    private LocalDate fecha;

    @Getter
    @Setter
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoProducto> productos = new ArrayList<>();


}
