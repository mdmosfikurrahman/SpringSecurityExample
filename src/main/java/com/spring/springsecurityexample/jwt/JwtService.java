package com.spring.springsecurityexample.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {
    public String generateToken() {
        return "JWT TOKEN";
    }
}
