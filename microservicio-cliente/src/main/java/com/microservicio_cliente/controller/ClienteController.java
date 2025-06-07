package com.microservicio_cliente.controller;


import com.microservicio_cliente.entity.Cliente;
import com.microservicio_cliente.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;


    @GetMapping("/get")
    public ResponseEntity<?> obtenerTodos(){
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/get/{idCliente}")
    public ResponseEntity<?> obtenerCliente(@PathVariable int idCliente){
        Cliente cliente = clienteService.obtenerClienteById(idCliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/search-my-pedido/{id}")
    public ResponseEntity<?> findByIdPedido(@PathVariable int id){
        return ResponseEntity.ok(clienteService.findByPedidoId(id));
    }

    @PostMapping("/post")
    public ResponseEntity<?> publciarCliente(@RequestBody Cliente cliente){
        Cliente postCliente = clienteService.crearCliente(cliente);
        return ResponseEntity.ok(postCliente +"creado");
    }

    @PutMapping("/put/{idCliente}")
    public ResponseEntity<?> editarCLiente(@PathVariable int idCliente, @RequestBody Cliente cliente){
        Cliente editarCliente = clienteService.actualizarCliente(idCliente, cliente);
        return  ResponseEntity.ok("Editado");
    }

    @DeleteMapping("/delete/{idCliente}")
    public ResponseEntity<?> eliminarCliente(@PathVariable int idCliente){
        clienteService.eliminarCliente(idCliente);
        return ResponseEntity.ok("Eliminado");
    }
}
