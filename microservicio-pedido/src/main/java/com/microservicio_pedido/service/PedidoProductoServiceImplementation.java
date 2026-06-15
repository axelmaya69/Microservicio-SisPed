package com.microservicio_pedido.service;

import com.microservicio_pedido.DTO.PedidoProductoDTO;
import com.microservicio_pedido.DTO.ProductoDTO;
import com.microservicio_pedido.clientes.IProductoFeignCliente;
import com.microservicio_pedido.entity.PedidoProducto;
import com.microservicio_pedido.repository.IPedidoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoProductoServiceImplementation implements IPedidoProductoService{

    @Autowired
    private IPedidoProducto IPP;

    @Autowired
    private IProductoFeignCliente productoFeignCliente;

    @Override
    public PedidoProducto crearPedidoProducto(PedidoProducto pedidoProducto) {
        ProductoDTO producto = productoFeignCliente.getProductoById(pedidoProducto.getIdProducto());
        if (producto.getStock() < pedidoProducto.getCantidad()) {
            throw new RuntimeException("Stock insuficiente para el producto '" + producto.getNombre() +
                    "'. Disponible: " + producto.getStock() + ", solicitado: " + pedidoProducto.getCantidad());
        }
        productoFeignCliente.reducirStock(pedidoProducto.getIdProducto(), pedidoProducto.getCantidad());
        return IPP.save(pedidoProducto);
    }

    @Override
    public PedidoProductoDTO obtenerPedidoProducto(int idPedidoProducto) {
        PedidoProducto entidad = IPP.findById(idPedidoProducto)
                .orElseThrow(() -> new RuntimeException("PedidoProducto no encontrado con id: " + idPedidoProducto));
        return new PedidoProductoDTO(entidad);
    }

    @Override
    public List<PedidoProductoDTO> obtenerPedidosProductos() {
        return IPP.findAll().stream()
                .map(PedidoProductoDTO::new)
                .collect(Collectors.toList());
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
