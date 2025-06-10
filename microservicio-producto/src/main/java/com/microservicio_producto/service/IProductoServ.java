package com.microservicio_producto.service;

import com.microservicio_producto.entity.Producto;

import java.util.List;

public interface IProductoServ {

    Producto crearProducto(Producto producto);

    Producto obtenerProducto(int idProducto);

    List <Producto> obtenerTodosProductos();

    Producto actualizarProductos(int idProducto, Producto producto);

    void eliminarProducto(int idProducto);


}
