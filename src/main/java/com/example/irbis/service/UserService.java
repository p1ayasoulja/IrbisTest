package com.example.irbis.service;

import com.example.irbis.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User findByUsername(String username);

    List<User> findAll();

    String getUsernameByToken(String token);
}
