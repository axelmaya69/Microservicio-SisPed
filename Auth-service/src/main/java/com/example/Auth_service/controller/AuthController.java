package com.example.Auth_service.controller;

import com.example.Auth_service.service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    IServiceUser serviceUser;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginRequest)

}
