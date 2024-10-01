package com.spring.springsecurityexample.service;

import com.spring.springsecurityexample.jwt.JwtService;
import com.spring.springsecurityexample.model.Users;
import com.spring.springsecurityexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public Users register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return user;

    }

    public String verify(Users users) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken();
        }
        return "failed";
    }
}
