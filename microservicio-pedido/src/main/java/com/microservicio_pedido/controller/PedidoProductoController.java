package com.microservicio_pedido.controller;

import com.microservicio_pedido.controller.DTO.PedidoProductoDTO;
import com.microservicio_pedido.entity.PedidoProducto;
import com.microservicio_pedido.service.IPedidoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pedidoproducto")
public class PedidoProductoController {

    @Autowired
    private IPedidoProductoService pedidoProductoService;

    @GetMapping("/get")
    public ResponseEntity<?> obtenerTodos(){
        List<PedidoProducto> obtenerPedidos = pedidoProductoService.obtenerPedidosProductos();
        return ResponseEntity.ok(obtenerPedidos);
    }

    @GetMapping("get/{idPedidoProd}")
    public ResponseEntity<?> obtenerPedidoProd(@PathVariable int idPedidoProd){
        PedidoProducto obtenerPed = pedidoProductoService.obtenerPedidoProducto(idPedidoProd);
        return ResponseEntity.ok(obtenerPed);
    }
/*
    @PostMapping("/post")
    public ResponseEntity<?> crearPedidoProd(@RequestBody PedidoProducto pedidoProducto){
        PedidoProducto crearPedidoProducto = pedidoProductoService.crearPedidoProducto(pedidoProducto);
        return ResponseEntity.ok(crearPedidoProducto);
    }
 */
    @PostMapping("/post")
    public ResponseEntity<PedidoProductoDTO> agregarProducto(@RequestBody PedidoProductoDTO dto){
        PedidoProductoDTO nuevo = pedidoProductoService.crearPedido(dto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PutMapping("/put/{idPedidoProd}")
    public ResponseEntity<?> editarPedidoProd(@PathVariable int idPedidoProd, @RequestBody PedidoProducto pedidoProducto){
        PedidoProducto putPedidoProducto = pedidoProductoService.editarPedidoProducto(idPedidoProd,pedidoProducto);
        return ResponseEntity.ok("editado");
    }

    @DeleteMapping("/delete/{idPedidoProd}")
    public ResponseEntity<?> deletePedidoProd(@PathVariable int idPedidoProd){
        pedidoProductoService.eliminarPedidoProducto(idPedidoProd);
        return ResponseEntity.ok("Eliminado");
    }

}
