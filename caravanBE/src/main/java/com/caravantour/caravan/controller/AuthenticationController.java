package com.caravantour.caravan.controller;

import com.caravantour.caravan.model.dto.UserDTO;
import com.caravantour.caravan.model.entity.User;
import com.caravantour.caravan.model.request.JwtAuthenticationResponse;
import com.caravantour.caravan.model.request.RefreshTokenRequest;
import com.caravantour.caravan.model.request.RefreshTokenResponse;
import com.caravantour.caravan.model.request.SignInRequest;
import com.caravantour.caravan.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(authenticationService.signup(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody SignInRequest signInRequest) {
        return authenticationService.signIn(signInRequest);
    }

    @PostMapping("/refresh")
    public ResponseEntity<RefreshTokenResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

    @GetMapping("/signout")
    public ResponseEntity<?> logoutUser(HttpServletRequest request) {
        authenticationService.signout(request);
        return ResponseEntity.ok("You've been signed out!");
    }

}
