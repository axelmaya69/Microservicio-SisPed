package com.microservicio_pedido.clientes;

import com.microservicio_pedido.DTO.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Feing hacia el microservicio producto
@FeignClient(name = "microservicio-producto",url = "http://localhost:9091/api/producto")
public interface IProductoFeignCliente {

    @GetMapping("/get/{id}")
    ProductoDTO getProductoById(@PathVariable int id);

    @PutMapping("/reducir-stock/{idProducto}/{cantidad}")
    ProductoDTO reducirStock(@PathVariable int idProducto, @PathVariable int cantidad);

}
