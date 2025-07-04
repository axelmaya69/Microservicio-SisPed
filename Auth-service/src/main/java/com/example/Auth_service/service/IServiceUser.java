package com.example.Auth_service.service;

import com.example.Auth_service.entity.User;

import java.util.List;

public interface IServiceUser {

    User registrarUser(User user);

    String logearUser(long idUser);


}
