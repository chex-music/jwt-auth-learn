package com.twd.jwt_auth.util;

import java.util.Date;

import org.apache.tomcat.util.net.openssl.ciphers.SignatureScheme;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Jwtutil {

	private static final String SECRET_KEY = "myseckey";

	public static String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	public static String validateToken(String token) {

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject(); // return username

        } catch (Exception e) {
            return null; // invalid token
        }
	}
}
