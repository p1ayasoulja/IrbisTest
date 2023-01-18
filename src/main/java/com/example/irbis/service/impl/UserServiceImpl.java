package com.example.irbis.service.impl;

import com.example.irbis.Entity.User;
import com.example.irbis.repo.UserRepo;
import com.example.irbis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);

    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public String getUsernameByToken(String token) {
        User user = userRepo.findByToken(token);
        return user.getUsername();
    }
}
