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
    public Servicio crearServicio(Servicio servicio) {
        return IntServ.save(servicio);
    }

    @Override
    public Servicio obtenerServicio(int idServicio) {
        return IntServ.findById(idServicio).orElseThrow();
    }

    @Override
    public List<Servicio> obtenerTodosServicios() {
        return IntServ.findAll();
    }

    @Override
    public List<Servicio> findByPedidoId(int idPedido) {
        return IntServ.findAllByPedidoId(idPedido);
    }

    @Override
    public Servicio actualizarServicio(int idServicio, Servicio servicio) {
        Servicio updateServicio = IntServ.findById(idServicio).get();
        if(IntServ.existsById(idServicio)){
            updateServicio.setNombre(servicio.getNombre());
            updateServicio.setDescripcion(servicio.getDescripcion());
            updateServicio.setPrecio(servicio.getPrecio());
            updateServicio.setCantidad(servicio.getCantidad());
            updateServicio.setIdPedido(servicio.getIdPedido());
        }
        return null;
    }
    @Override
    public void eliminarServicio(int idServicio) {
    IntServ.deleteById(idServicio);
    }
}
