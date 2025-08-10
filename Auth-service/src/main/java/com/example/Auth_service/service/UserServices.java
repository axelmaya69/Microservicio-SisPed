package com.example.Auth_service.service;


import com.example.Auth_service.entity.User;
import com.example.Auth_service.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {

    private final IUserRepository iUserRepository;


    public UserServices(IUserRepository iUserRepository){
        this.iUserRepository= iUserRepository;
    }

    public List<User> allUsers(){

        List<User> users = new ArrayList<>();

        iUserRepository.findAll().forEach(users::add);

        return users;
    }


}
