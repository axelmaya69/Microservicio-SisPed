package com.example.Auth_service.service;

import com.example.Auth_service.entity.User;
import com.example.Auth_service.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IServiceUserApplication implements  IServiceUser{

    @Autowired
    IUserRepository userRepository;



    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secretKey;

    @Override
    public User registrarUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public String logearUser(String username, String password) {
        return "";
    }
}
