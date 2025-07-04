package com.example.Auth_service.service;

import com.example.Auth_service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IServiceUserApplication implements  IServiceUser{

    @Autowired
    IServiceUser serviceUser;



    @Override
    public User registrarUser(User user) {
        return null;
    }

    @Override
    public String logearUser(long idUser) {
        return "";
    }

}
