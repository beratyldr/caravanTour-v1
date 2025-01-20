package com.caravantour.caravan.service;


import com.caravantour.caravan.model.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface JWTService {
    String generateToken(UserDetailsImpl userDetails);

    String extractUserName(String token);

    boolean isTokenValid(String token, UserDetailsImpl userDetails);

    String generateRefreshToken(HashMap<String, Object> extraClaims, UserDetails userDetails);

//    String resolveToken(HttpServletRequest request);

    void invalidateToken(HttpServletRequest request);

    ResponseCookie generateJwtCookie(UserDetailsImpl userDetails);

//    ResponseCookie getCleanJwtCookie();

    String getJwtFromCookies(HttpServletRequest request);

    boolean validateJwtToken(String authToken, UserDetailsImpl userDetails);
}
