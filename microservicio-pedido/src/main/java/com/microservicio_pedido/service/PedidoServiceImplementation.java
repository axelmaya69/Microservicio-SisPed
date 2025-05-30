package com.microservicio_pedido.service;


import com.microservicio_pedido.cliente.IClientePedido;
import com.microservicio_pedido.controller.DTO.PedidoDTO;
import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.http.response.ClienteByPedidoResponse;
import com.microservicio_pedido.repository.IPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImplementation implements IPedidoService{

    @Autowired
    private IPedido iPedido;

    @Autowired
    private IClientePedido clientePedido;

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
/*
    @Override
    public ClienteByPedidoResponse findClientesByIdPedidos(int id) {
        Pedido pedido = iPedido.findById(id).orElse(new Pedido());

        List<PedidoDTO> clienteDTOSs = clientePedido.findAllClientsByServicio(id);
        return ClienteByPedidoResponse.builder()
                .clienteId(pedido.getClienteId())
                .fecha(pedido.getFecha())
                .productos(pedido.getProducos())
                .clienteDTOS(clienteDTOSs)
                .build();
    }
 */

    @Override
    public Pedido editarPedido(int idPedido, Pedido pedido) {
        Pedido updatePedido = iPedido.findById(idPedido).get();
        if(iPedido.existsById(idPedido)){
            updatePedido.setClienteId(pedido.getClienteId());
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
