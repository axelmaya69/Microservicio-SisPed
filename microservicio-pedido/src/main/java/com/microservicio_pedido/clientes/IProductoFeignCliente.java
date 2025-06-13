package com.microservicio_pedido.clientes;

import com.microservicio_pedido.controller.DTO.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-producto",url = "http://localhost:8080/api/producto")
public interface IProductoFeignCliente {

    @GetMapping("/get/{id}")
    ProductoDTO getProductoById(@PathVariable int id);


}
