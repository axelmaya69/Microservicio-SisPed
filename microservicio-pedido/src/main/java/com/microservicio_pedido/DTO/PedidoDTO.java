package com.microservicio_pedido.DTO;

import com.microservicio_pedido.entity.PedidoProducto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class PedidoDTO{

    private int idPedido;

    private int idCliente;

    private LocalDate fecha;

    //Obtiene tambien una lista de todos los pedidos
    private List<PedidoProducto> productos;
}
