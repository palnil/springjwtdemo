package com.yoshallc.security.demo;


public class SecurityConstants {
    private static final String SECRET = "secret";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_STRING = "Authorization";
}