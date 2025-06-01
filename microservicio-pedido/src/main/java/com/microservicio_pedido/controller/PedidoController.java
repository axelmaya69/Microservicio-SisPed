package com.microservicio_pedido.controller;

import com.microservicio_pedido.controller.DTO.CrearPedidoDTO;
import com.microservicio_pedido.controller.DTO.PedidoDTO;
import com.microservicio_pedido.controller.DTO.PedidoDetalleDTO;
import com.microservicio_pedido.entity.Pedido;
import com.microservicio_pedido.entity.PedidoProducto;
import com.microservicio_pedido.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pedido")
@RestController
public class PedidoController {
    @Autowired
    private IPedidoService pedidoService;

    @GetMapping("/get")
    public ResponseEntity<?> obtenerTodos(){
        List<Pedido> obtenerPedidos = pedidoService.obtenerPedidos();
        return ResponseEntity.ok(obtenerPedidos);
    }

    @GetMapping("get/{idPedido}/detalle")
    public ResponseEntity<PedidoDetalleDTO> obtenerDetalle(@PathVariable int id) {
        return ResponseEntity.ok(pedidoService.obtenerDetalle(id));
    }

    @GetMapping("get/{idPedido}")
    public ResponseEntity<?> obtenerPedido(@PathVariable int idPedido){
        Pedido obtenerPed = pedidoService.obtenerPedido(idPedido);
        return ResponseEntity.ok(obtenerPed);
    }

    /*
    @PostMapping("/post")
    public ResponseEntity<?> crearPedido(@RequestBody Pedido pedido){
        Pedido crearPedido = pedidoService.crearPedido(pedido);
        return ResponseEntity.ok(crearPedido);
    }
     */
    @PostMapping("/post")
    public ResponseEntity<PedidoDTO> crearPedido(@RequestBody CrearPedidoDTO dto){
        PedidoDTO nuevopedidoDTO = pedidoService.crearPedido(dto);
        return new ResponseEntity<>(nuevopedidoDTO, HttpStatus.CREATED);
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
