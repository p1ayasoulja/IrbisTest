package com.example.irbis.security.Jwt;

import com.example.irbis.Entity.User;

public final class JwtUserFactory {
    public static JwtUser create(User user) {
        return new JwtUser(user.getId(), user.getUsername(), user.getToken());
    }
}
