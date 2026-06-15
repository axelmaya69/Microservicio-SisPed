package com.example.Auth_service.controller;
import com.example.Auth_service.dtos.LoginRequest;
import com.example.Auth_service.dtos.LoginResponse;
import com.example.Auth_service.dtos.RegisterRequest;
import com.example.Auth_service.dtos.UserResponse;
import com.example.Auth_service.entity.User;
import com.example.Auth_service.service.AuthenticationService;
import com.example.Auth_service.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;


    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest) {
        User registerUser = authenticationService.signup(registerRequest);
        UserResponse response = new UserResponse();
        response.setId(registerUser.getId());
        response.setEmail(registerUser.getEmail());
        response.setFullName(registerUser.getFullName());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginRequest){
        User authenticatedUser = authenticationService.authenticate(loginRequest);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}