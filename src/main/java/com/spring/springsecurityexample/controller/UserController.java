package com.spring.springsecurityexample.controller;

import com.spring.springsecurityexample.model.JwtTokenResponse;
import com.spring.springsecurityexample.model.Users;
import com.spring.springsecurityexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/users")
    public Users registerUser(@RequestBody Users user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public JwtTokenResponse login(@RequestBody Users users) {
        return service.verify(users);
    }

}
