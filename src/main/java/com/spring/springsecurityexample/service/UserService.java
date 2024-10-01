package com.spring.springsecurityexample.service;

import com.spring.springsecurityexample.model.Users;
import com.spring.springsecurityexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public Users register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return user;

    }

}
