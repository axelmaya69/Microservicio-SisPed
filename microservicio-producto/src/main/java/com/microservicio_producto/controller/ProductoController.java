package com.microservicio_producto.controller;

import com.microservicio_producto.entity.Producto;
import com.microservicio_producto.service.IProductoServ;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/producto")
public class ProductoController {


    @Autowired
    private IProductoServ productoServ;


    @GetMapping("/get")
    public ResponseEntity<?> obtenerTodos(){
        List<Producto> productos = productoServ.obtenerTodosProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/get/{idProducto}")
    public ResponseEntity<?> obtenerId(@PathVariable int idProducto){
        Producto unProducto = productoServ.obtenerProducto(idProducto);
        return ResponseEntity.ok(unProducto);
    }

    @PostMapping("/post")
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto){
        Producto crearProducto = productoServ.crearProducto(producto);
        return ResponseEntity.ok(crearProducto);
    }

    @PutMapping("/put/idProducto")
    public ResponseEntity<?> editarProducto(@PathVariable int idProducto, @RequestBody Producto producto){
        Producto updateService = productoServ.actualizarProductos(idProducto, producto);
        return ResponseEntity.ok("Editado");
    }

    @DeleteMapping("/delete/{idProducto}")
    public ResponseEntity<?> deleteProducto(@PathVariable int idProducto){
        productoServ.eliminarProducto(idProducto);
        return ResponseEntity.ok("eliminado");
    }
}
