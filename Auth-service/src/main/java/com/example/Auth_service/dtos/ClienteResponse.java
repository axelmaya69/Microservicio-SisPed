package com.example.Auth_service.dtos;


import lombok.Data;

@Data
public class ClienteResponse {

    private int id;

    private String nombre;

    private String apellidoP;

    private String apellidoM;

    private String telefono;

}
