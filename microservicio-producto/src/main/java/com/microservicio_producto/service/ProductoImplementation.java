package com.microservicio_producto.service;

import com.microservicio_producto.entity.Producto;
import com.microservicio_producto.repository.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioImplementation implements IProductoServ {

    @Autowired
    private IProducto IntServ;

    @Override
    public Producto crearServicio(Producto producto) {
        return IntServ.save(producto);
    }

    @Override
    public Producto obtenerServicio(int idServicio) {
        return IntServ.findById(idServicio).orElseThrow();
    }

    @Override
    public List<Producto> obtenerTodosServicios() {
        return IntServ.findAll();
    }



    @Override
    public Producto actualizarServicio(int idServicio, Producto producto) {
        Producto updateProducto = IntServ.findById(idServicio).get();
        if(IntServ.existsById(idServicio)){
            updateProducto.setNombre(producto.getNombre());
            updateProducto.setDescripcion(producto.getDescripcion());
            updateProducto.setPrecio(producto.getPrecio());
            return IntServ.save(updateProducto);
        }
        return null;
    }
    @Override
    public void eliminarServicio(int idServicio) {
    IntServ.deleteById(idServicio);
    }
}
