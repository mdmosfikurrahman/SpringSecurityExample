package com.spring.springsecurityexample.model;

public record JwtTokenResponse(String token, String username, String issuedAt, String expiration) {
}