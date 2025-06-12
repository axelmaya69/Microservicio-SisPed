package com.microservicio_pedido.clientes;

import com.microservicio_pedido.controller.DTO.ProductoDTO;
import com.microservicio_pedido.controller.DTO.ProductoDetalleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservicio-producto",url = "http://localhost:8080/api/producto")
public interface IClientProducto {

    @GetMapping("/get/{id}")
    ProductoDTO getProductoPorId(@PathVariable int id);
}
