package com.example.Auth_service.service;

import com.example.Auth_service.dtos.ClienteRequest;
import com.example.Auth_service.entity.User;

import java.util.List;

public interface IServiceUser {

    User registrarUser(String username, String password, ClienteRequest clienteReques);

    String logearUser(String username, String password);


}
