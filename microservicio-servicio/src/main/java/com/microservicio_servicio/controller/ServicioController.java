package com.microservicio_servicio.controller;

import com.microservicio_servicio.entity.Servicio;
import com.microservicio_servicio.service.IServiceServ;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio")
public class ServicioController {

    @Autowired
    IServiceServ serviceServ;


    @GetMapping("/get")
    public ResponseEntity<?> obtenerTodos(){
        List<Servicio> servicios = serviceServ.obtenerTodosServicios();
        return ResponseEntity.ok(servicios);
    }

    @GetMapping("/get/{idServicio}")
    public ResponseEntity<?> obtenerId(@PathVariable int idServicio){
        Servicio unServicio = serviceServ.obtenerServicio(idServicio);
        return ResponseEntity.ok(unServicio);
    }

    @GetMapping("/search-my-pedido/{idPedido}")
    public ResponseEntity<?> obtenerPedido(@PathVariable int idPedido){
        return ResponseEntity.ok(serviceServ.findByPedidoId(idPedido));
    }

    @PostMapping("/post")
    public ResponseEntity<?> crearServicio(@RequestBody Servicio servicio){
        Servicio crearServicio = serviceServ.crearServicio(servicio);
        return ResponseEntity.ok(crearServicio);
    }

    @PutMapping("/put/idServicio")
    public ResponseEntity<?> editarServicio(@PathVariable int idServicio, @RequestBody Servicio servicio){
        Servicio updateService = serviceServ.actualizarServicio(idServicio,servicio);
        return ResponseEntity.ok("Editado");
    }

    @DeleteMapping("/delete/{idServicio}")
    public ResponseEntity<?> deleteService(@PathVariable int idServicio){
        serviceServ.eliminarServicio(idServicio);
        return ResponseEntity.ok("eliminado");
    }
}
