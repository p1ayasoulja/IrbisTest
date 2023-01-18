package com.example.irbis.security.Jwt;

import com.example.irbis.Entity.User;
import com.example.irbis.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtTokenProvider {
    public UserService userService;
    private UserDetailsService userDetailsService;

    public JwtTokenProvider(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    public String getToken(String username) {
        User user = userService.findByUsername(username);
        return user.getToken();

    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer_")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return userService.getUsernameByToken(token);
    }

    public boolean validateToken(String token) {
        List<User> userList = userService.findAll();
        List<String> tokenList = new ArrayList<>();
        userList.forEach(user -> tokenList.add(user.getToken()));
        if (tokenList.contains(token))
            return true;
        else return false;
    }

}
