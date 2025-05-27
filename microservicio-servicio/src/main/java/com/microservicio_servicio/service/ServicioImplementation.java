package com.microservicio_servicio.service;

import com.microservicio_servicio.entity.Servicio;
import com.microservicio_servicio.repository.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioImplementation implements IServiceServ{

    @Autowired
    IServicio IntServ;


    @Override
    public Servicio actualizarServicio(int idServicio, Servicio servicio) {
        return null;
    }

    @Override
    public Servicio crearServicio(Servicio servicio) {
        return null;
    }

    @Override
    public Servicio obtenerServicio(int idServicio) {
        return null;
    }

    @Override
    public List<Servicio> obtenerTodosServicios() {
        return List.of();
    }

    @Override
    public List<Servicio> findByPedidoId(int idPedido) {
        return List.of();
    }

    @Override
    public void eliminarServicio(int idServicio) {

    }
}
