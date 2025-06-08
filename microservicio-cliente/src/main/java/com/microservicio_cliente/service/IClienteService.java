package com.microservicio_cliente.service;

import com.microservicio_cliente.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IClienteService {

    Cliente crearCliente(Cliente cliente);

    Cliente obtenerClienteById(int idCliente);



    List<Cliente> obtenerTodosLosClientes();

    Cliente actualizarCliente(int idCliente, Cliente cliente);

    void eliminarCliente(int idCliente);


}
