package com.example.Auth_service.feigns;

import com.example.Auth_service.dtos.ClienteRequest;
import com.example.Auth_service.dtos.ClienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservicio-cliente",url = "http://localhost:9080/api/cliente")
public interface IClienteFeignClient {

    @PostMapping("/post")
    ClienteResponse crearCliente(@RequestBody ClienteRequest cliente);
}
