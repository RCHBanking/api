package com.rchbanking.api.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;

@Service
public class JWTUtils {

    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public String generateToken(String username) {
        return Jwts.builder().setClaims(new HashMap<String, Object>())
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS256)).compact();
    }
}
