package com.example.Auth_service.repository;

import com.example.Auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
