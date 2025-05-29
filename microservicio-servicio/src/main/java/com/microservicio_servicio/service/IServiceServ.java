package com.microservicio_servicio.service;

import com.microservicio_servicio.entity.Servicio;

import java.util.List;

public interface IServiceServ {

    Servicio crearServicio(Servicio servicio);

    Servicio obtenerServicio(int idServicio);

    List <Servicio> obtenerTodosServicios();

    Servicio actualizarServicio(int idServicio, Servicio servicio);

    void eliminarServicio(int idServicio);


}
