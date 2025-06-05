package com.microservicio_producto.service;

import com.microservicio_producto.entity.Producto;

import java.util.List;

public interface IProductoServ {

    Producto crearServicio(Producto producto);

    Producto obtenerServicio(int idServicio);

    List <Producto> obtenerTodosServicios();

    Producto actualizarServicio(int idServicio, Producto producto);

    void eliminarServicio(int idServicio);


}
