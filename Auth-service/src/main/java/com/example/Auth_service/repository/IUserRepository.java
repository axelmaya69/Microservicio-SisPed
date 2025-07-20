package com.example.Auth_service.repository;

import com.example.Auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional <User> findByEmail(String email);

}
