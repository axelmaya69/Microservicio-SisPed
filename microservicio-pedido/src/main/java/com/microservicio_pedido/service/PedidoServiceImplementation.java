package com.microservicio_pedido.service;

import com.microservicio_pedido.DTO.*;
import com.microservicio_pedido.clientes.IProductoFeignCliente;
import com.microservicio_pedido.clientes.IClienteFeignCliente;
import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.entity.PedidoProducto;
import com.microservicio_pedido.http.responses.ClienteByPedidoResponse;
import com.microservicio_pedido.http.responses.ProductoByPedidoProductoResponse;
import com.microservicio_pedido.repository.IPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImplementation implements IPedidoService{

    @Autowired
    private IPedido iPedido;

    @Autowired
    IClienteFeignCliente iCliente;

    @Autowired
    IProductoFeignCliente clientProducto;

    @Autowired
    IPedidoProductoService productoService;

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return iPedido.save(pedido);
    }


    @Override
    public Pedido obtenerPedido(int idPedido) {
        return iPedido.findById(idPedido).orElseThrow();
    }


//ANALIZAR BIEN COMO FUNCIONA ESTE METODO:
    @Override
    public ClienteByPedidoResponse obtenerPedidosPorCliente(int id) {
        Pedido pedido = iPedido.findById(id).orElse(new Pedido());

        ClienteDTO  clienteDTOList = iCliente.getClientById(pedido.getIdCliente());
        return ClienteByPedidoResponse.builder()
                .idPedido(pedido.getIdPedido())
                .fecha(pedido.getFecha())
                .idCliente(pedido.getIdCliente())
                .clienteDTO(clienteDTOList)
                .build();
    }

    @Override
    public List<Pedido> obtenerPedidos() {
        return iPedido.findAll();
    }

    @Override
    public ProductoByPedidoProductoResponse obtenerProductosByIdPedido(int idPedido) {
        Pedido pedido = iPedido.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        ClienteDTO clienteDTO = iCliente.getClientById(pedido.getIdCliente());

        //Se crea una lista con todos los productos
        List<ProductoDetalleDTO> productosDetallados = new ArrayList<>();

        for (PedidoProducto pp : pedido.getProductos()) {
            ProductoDTO productoDTO = clientProducto.getProductoById(pp.getIdProducto());

            ProductoDetalleDTO detallado = ProductoDetalleDTO.builder()
                    .idProducto(productoDTO.getIdProducto())
                    .nombre(productoDTO.getNombre())
                    .precio(productoDTO.getPrecio())
                    .cantidad(pp.getCantidad())
                    .precioUnitario(pp.getPrecioUnitario())

                    .build();

            productosDetallados.add(detallado);
        }

        //Agregando total
    float total = productosDetallados.stream().map(p -> p.getCantidad() * p.getPrecioUnitario())
            .reduce(0f,Float::sum);

        return ProductoByPedidoProductoResponse.builder()
                .idPedido(pedido.getIdPedido())
                .cliente(clienteDTO)
                .productos(productosDetallados)
                .fecha(pedido.getFecha())
                .total(total)
                .build();
    }


    @Override
    public Pedido editarPedido(int idPedido, Pedido pedido) {
        Pedido updatePedido = iPedido.findById(idPedido).get();
        if(iPedido.existsById(idPedido)){
            updatePedido.setIdCliente(pedido.getIdCliente());
            updatePedido.setFecha(pedido.getFecha());
            updatePedido.setProductos(pedido.getProductos());
            return iPedido.save(updatePedido);
        }return null;
    }

    @Override
    public void eliminarPedido(int idPedido) {
    iPedido.deleteById(idPedido);
    }
}
