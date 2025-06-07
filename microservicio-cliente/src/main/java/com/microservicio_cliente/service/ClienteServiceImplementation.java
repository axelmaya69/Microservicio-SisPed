package com.microservicio_cliente.service;

import com.microservicio_cliente.entity.Cliente;
import com.microservicio_cliente.repository.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplementation implements  IClienteService{

    @Autowired
    ICliente Intcliente;


    @Override
    public Cliente crearCliente(Cliente cliente) {
        return Intcliente.save(cliente);
    }

    @Override
    public Cliente obtenerClienteById(int idCliente) {
        return Intcliente.findById(idCliente).orElseThrow();
    }

    @Override
    public List<Cliente> findByPedidoId(int id) {
        return Intcliente.findAllByIdPedido(id);
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return Intcliente.findAll();
    }

    @Override
    public Cliente actualizarCliente(int idCliente, Cliente cliente) {
        Cliente updateCliente = Intcliente.findById(idCliente).get();
        if(Intcliente.existsById(idCliente)){
            updateCliente.setNombre(cliente.getNombre());
            updateCliente.setApellidoP(cliente.getApellidoP());
            updateCliente.setApellidoM(cliente.getApellidoM());
            updateCliente.setEmail(cliente.getEmail());
            return Intcliente.save(updateCliente);
        }return null;
    }

    @Override
    public void eliminarCliente(int idCliente) {
    Intcliente.deleteById(idCliente);
    }
}
