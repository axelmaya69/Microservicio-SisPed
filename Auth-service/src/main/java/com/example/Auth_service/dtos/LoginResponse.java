package com.example.Auth_service.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LoginResponse {

    private String token;

    private long expiresIn;

}
