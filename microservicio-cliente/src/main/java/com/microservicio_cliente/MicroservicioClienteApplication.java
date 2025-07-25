package com.microservicio_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class  MicroservicioClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioClienteApplication.class, args);
	}

}
