package com.caravantour.caravan.service;

import com.caravantour.caravan.model.dto.UserDTO;
import com.caravantour.caravan.model.entity.User;
import com.caravantour.caravan.model.request.JwtAuthenticationResponse;
import com.caravantour.caravan.model.request.RefreshTokenRequest;
import com.caravantour.caravan.model.request.RefreshTokenResponse;
import com.caravantour.caravan.model.request.SignInRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    String signup(UserDTO signUpRequest);

    ResponseEntity<JwtAuthenticationResponse> signIn(SignInRequest signInRequest);

    RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    void signout(HttpServletRequest request);
}
