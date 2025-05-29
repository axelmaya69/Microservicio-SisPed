package com.microservicio_servicio.service;

import com.microservicio_servicio.entity.Servicio;
import com.microservicio_servicio.repository.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioImplementation implements IServiceServ{

    @Autowired
    private IServicio IntServ;

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
    public Servicio actualizarServicio(int idServicio, Servicio servicio) {
        Servicio updateServicio = IntServ.findById(idServicio).get();
        if(IntServ.existsById(idServicio)){
            updateServicio.setNombre(servicio.getNombre());
            updateServicio.setDescripcion(servicio.getDescripcion());
            updateServicio.setPrecio(servicio.getPrecio());
            return IntServ.save(updateServicio);
        }
        return null;
    }
    @Override
    public void eliminarServicio(int idServicio) {
    IntServ.deleteById(idServicio);
    }
}
