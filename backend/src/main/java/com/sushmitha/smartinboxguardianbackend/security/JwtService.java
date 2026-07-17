package com.sushmitha.smartinboxguardianbackend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtService {

    public String generateToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    private static final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor(
                    "mySecretKeyForJwtAuthentication123456789012345".getBytes()
            );

}