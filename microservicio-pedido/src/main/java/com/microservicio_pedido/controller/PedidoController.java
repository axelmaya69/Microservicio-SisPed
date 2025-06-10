package com.microservicio_pedido.controller;


import com.microservicio_pedido.cliente.ICliente;
import com.microservicio_pedido.controller.DTO.ClienteDTO;
import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @Autowired
    private ICliente iCliente;

    @GetMapping("/get")
    public ResponseEntity<?> obtenerTodos(){
        List<Pedido> obtenerPedidos = pedidoService.obtenerPedidos();
        return ResponseEntity.ok(obtenerPedidos);
    }

    @GetMapping("/get/cliente/{clienteId}")
    public ResponseEntity<?> obtenerCliente(@PathVariable int clienteId) {
        return ResponseEntity.ok(pedidoService.obtenerPedidosPorCliente(clienteId));
    }

    @GetMapping("get/{idPedido}")
    public ResponseEntity<?> obtenerPedido(@PathVariable int idPedido){
        Pedido obtenerPed = pedidoService.obtenerPedido(idPedido);
        return ResponseEntity.ok(obtenerPed);
    }


    @PostMapping("/post")
    public ResponseEntity<?> crearPedido(@RequestBody Pedido pedido){
        Pedido crearPedido = pedidoService.crearPedido(pedido);
        return ResponseEntity.ok(crearPedido);
    }

    @PutMapping("/put/{idPedido}")
    public ResponseEntity<?> editarPedido(@PathVariable int idPedido, @RequestBody Pedido pedido){
        Pedido putPedido = pedidoService.editarPedido(idPedido, pedido);
        return ResponseEntity.ok("editado");
    }

    @DeleteMapping("/delete/{idPedido}")
    public ResponseEntity<?> deletePedido(@PathVariable int idPedido){
        pedidoService.eliminarPedido(idPedido);
        return ResponseEntity.ok("Eliminado");
    }


}
