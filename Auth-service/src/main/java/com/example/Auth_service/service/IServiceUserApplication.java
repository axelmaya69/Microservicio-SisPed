package com.example.Auth_service.service;

import com.example.Auth_service.dtos.ClienteRequest;
import com.example.Auth_service.dtos.ClienteResponse;
import com.example.Auth_service.entity.User;
import com.example.Auth_service.feigns.IClienteFeignClient;
import com.example.Auth_service.repository.IUserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
    IClienteFeignClient feignClient;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secretKey;

    @Override
    public User registrarUser(String username, String password, ClienteRequest clienteRequest) {

        ClienteResponse clienteResponse = feignClient.crearCliente(clienteRequest);

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setClienteId(clienteResponse.getId());

        return userRepository.save(user);
    }

    @Override
    public String logearUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new RuntimeException("Usuario No encontrado");
        }
        if(!passwordEncoder.matches(password,user.getPassword())){
            throw new RuntimeException("Contraseña incorrecta");
        }
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("clienteId",user.getClienteId())
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
