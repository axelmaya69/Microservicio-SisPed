package com.microservicio_pedido.service;

import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.repository.IPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServiceImplementation implements IPedidoService{

    @Autowired
    private IPedido iPedido;


    @Override
    public Pedido crearPedido(Pedido pedido) {
        return iPedido.save(pedido);
    }


    @Override
    public Pedido obtenerPedido(int idPedido) {
        return iPedido.findById(idPedido).orElseThrow();
    }

    @Override
    public List<Pedido> obtenerPedidos() {
        return iPedido.findAll();
    }


    @Override
    public Pedido editarPedido(int idPedido, Pedido pedido) {
        Pedido updatePedido = iPedido.findById(idPedido).get();
        if(iPedido.existsById(idPedido)){
            updatePedido.setIdCliente(pedido.getIdCliente());
            updatePedido.setFecha(pedido.getFecha());
            updatePedido.setProducos(pedido.getProducos());
            return iPedido.save(updatePedido);
        }return null;
    }

    @Override
    public void eliminarPedido(int idPedido) {
    iPedido.deleteById(idPedido);
    }
}
