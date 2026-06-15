package com.microservicio_producto.service;

import com.microservicio_producto.entity.Producto;
import com.microservicio_producto.repository.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoImplementation implements IProductoServ {

    @Autowired
    private IProducto IntServ;

    @Override
    public Producto crearProducto(Producto producto) {
        return IntServ.save(producto);
    }

    @Override
    public Producto obtenerProducto(int idProducto) {
        return IntServ.findById(idProducto).orElseThrow();
    }

    @Override
    public List<Producto> obtenerTodosProductos() {
        return IntServ.findAll();
    }



    @Override
    public Producto actualizarProductos(int idProducto, Producto producto) {
        Producto updateProducto = IntServ.findById(idProducto).get();
        if(IntServ.existsById(idProducto)){
            updateProducto.setNombre(producto.getNombre());
            updateProducto.setDescripcion(producto.getDescripcion());
            updateProducto.setPrecio(producto.getPrecio());
            return IntServ.save(updateProducto);
        }
        return null;
    }
    @Override
    public void eliminarProducto(int idProducto) {
        IntServ.deleteById(idProducto);
    }

    @Override
    public Producto reducirStock(int idProducto, int cantidad) {
        Producto producto = IntServ.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + idProducto));
        if (producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente para el producto id: " + idProducto +
                    ". Stock disponible: " + producto.getStock() + ", solicitado: " + cantidad);
        }
        producto.setStock(producto.getStock() - cantidad);
        return IntServ.save(producto);
    }
}
