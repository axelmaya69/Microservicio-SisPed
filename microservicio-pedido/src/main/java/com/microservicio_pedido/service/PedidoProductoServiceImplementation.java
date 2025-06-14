package com.microservicio_pedido.service;

import com.microservicio_pedido.clientes.IProductoFeignCliente;
import com.microservicio_pedido.controller.DTO.PedidoProductoDTO;
import com.microservicio_pedido.controller.DTO.ProductoDTO;
import com.microservicio_pedido.entity.PedidoProducto;
import com.microservicio_pedido.http.responses.ProductoByPedidoProductoResponse;
import com.microservicio_pedido.repository.IPedidoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoProductoServiceImplementation implements IPedidoProductoService{

    @Autowired
    private IPedidoProducto IPP;

    @Autowired
    private IProductoFeignCliente clientProducto;

    @Override
    public PedidoProducto crearPedidoProducto(PedidoProducto pedidoProducto) {
        return IPP.save(pedidoProducto);
    }

    @Override
    public PedidoProducto obtenerPedidoProducto(int idPedidoProducto) {
        return IPP.findById(idPedidoProducto).orElseThrow();
    }

    @Override
    public ProductoByPedidoProductoResponse obtenerProductosByIdPedido(int productoId) {
        PedidoProducto pedidoProducto = IPP.findById(productoId).orElse(new PedidoProducto());

        ProductoDTO productoDTO = clientProducto.getProductoById(pedidoProducto.getIdProducto());
        return ProductoByPedidoProductoResponse.builder()
                .idPedidoProducto(pedidoProducto.getIdPedidoProducto())
                .idProducto(pedidoProducto.getIdProducto())
                .cantidad(pedidoProducto.getCantidad())
                .precioUnitario(pedidoProducto.getPrecioUnitario())
                .idPedido(pedidoProducto.getPedido().getIdPedido())
                .productoDTO(List.of(productoDTO))
                .build();
    }



    @Override
    public List<PedidoProducto> obtenerPedidosProductos() {
        return IPP.findAll();
    }


    @Override
    public PedidoProducto editarPedidoProducto(int idPedidoProducto, PedidoProducto pedidoProducto) {
        PedidoProducto updatePedidoProducto = IPP.findById(idPedidoProducto).get();
        if(IPP.existsById(idPedidoProducto)){
            updatePedidoProducto.setIdProducto(pedidoProducto.getIdProducto());
            updatePedidoProducto.setCantidad(pedidoProducto.getCantidad());
            updatePedidoProducto.setPrecioUnitario(pedidoProducto.getPrecioUnitario());
            updatePedidoProducto.setPedido(pedidoProducto.getPedido());
            return IPP.save(updatePedidoProducto);
        }return null;
    }

    @Override
    public void eliminarPedidoProducto(int idPedidoProducto) {
    IPP.deleteById(idPedidoProducto);
    }
}
