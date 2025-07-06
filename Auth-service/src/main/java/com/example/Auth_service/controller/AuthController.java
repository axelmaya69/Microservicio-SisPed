package com.example.Auth_service.controller;

import com.example.Auth_service.dtos.LoginRequest;
import com.example.Auth_service.dtos.LoginResponse;
import com.example.Auth_service.entity.User;
import com.example.Auth_service.service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> register(@RequestBody LoginRequest request){
        User user = serviceUser.registrarUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok("Usuario"+ user.getUsername()+" registrado");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        try{
            String token = serviceUser.logearUser(request.getUsername(), request.getPassword());
            return ResponseEntity.ok(new LoginResponse(token));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
