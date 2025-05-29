package com.microservicio_servicio.repository;

import com.microservicio_servicio.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServicio extends JpaRepository<Servicio,Integer> {
}
