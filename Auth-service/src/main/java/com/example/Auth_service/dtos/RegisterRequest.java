package com.example.Auth_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;
}
