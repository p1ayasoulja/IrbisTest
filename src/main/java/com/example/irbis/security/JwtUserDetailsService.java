package com.example.irbis.security;

import com.example.irbis.Entity.User;
import com.example.irbis.security.Jwt.JwtUser;
import com.example.irbis.security.Jwt.JwtUserFactory;
import com.example.irbis.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}
