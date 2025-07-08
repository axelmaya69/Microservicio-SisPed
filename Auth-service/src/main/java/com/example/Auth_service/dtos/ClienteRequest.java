package com.example.Auth_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Data
public class ClienteRequest {

    private String nombre;

    private String apellidoP;

    private String apellidoM;

    private String telefono;




}
