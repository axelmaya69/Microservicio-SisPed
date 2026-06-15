package com.example.Auth_service.controller;


import com.example.Auth_service.dtos.UserResponse;
import com.example.Auth_service.entity.User;
import com.example.Auth_service.service.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@RequestMapping("/users")
@RestController
public class UserController {

    private final UserServices userService;

    public UserController(UserServices userService){
        this.userService= userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        UserResponse response = new UserResponse();
        response.setId(currentUser.getId());
        response.setEmail(currentUser.getEmail());
        response.setFullName(currentUser.getFullName());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> allUsers() {
        List<UserResponse> users = userService.allUsers().stream()
                .map(u -> {
                    UserResponse r = new UserResponse();
                    r.setId(u.getId());
                    r.setEmail(u.getEmail());
                    r.setFullName(u.getFullName());
                    return r;
                })
                .toList();
        return ResponseEntity.ok(users);
    }
}
