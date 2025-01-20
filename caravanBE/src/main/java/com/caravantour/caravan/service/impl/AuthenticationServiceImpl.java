package com.caravantour.caravan.service.impl;

import com.caravantour.caravan.model.UserDetailsImpl;
import com.caravantour.caravan.model.dto.UserDTO;
import com.caravantour.caravan.model.entity.RoleEntity;
import com.caravantour.caravan.model.entity.User;
import com.caravantour.caravan.model.entity.car.CarBrandModel;
import com.caravantour.caravan.model.mapper.UserMapper;
import com.caravantour.caravan.model.request.JwtAuthenticationResponse;
import com.caravantour.caravan.model.request.RefreshTokenRequest;
import com.caravantour.caravan.model.request.RefreshTokenResponse;
import com.caravantour.caravan.model.request.SignInRequest;
import com.caravantour.caravan.repository.jpa.RoleRepository;
import com.caravantour.caravan.repository.jpa.UserRepository;
import com.caravantour.caravan.service.AuthenticationService;
import com.caravantour.caravan.service.JWTService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;


    @Override
    public String signup(UserDTO userDTO) {
        RoleEntity role=roleRepository.findByName(userDTO.getRole());
        if(Objects.nonNull(role)){
            Set<RoleEntity> roles=new HashSet<>();
            roles.add(role);
            userDTO.setRoles(roles);
        }

        userRepository.save(userMapper.toUser(userDTO));
        return Objects.requireNonNull(signIn(new SignInRequest(userDTO.getEmail(), userDTO.getPassword())).getBody()).getToken();
    }

    @Override
    public ResponseEntity<JwtAuthenticationResponse> signIn(SignInRequest signInRequest) {


        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtService.generateToken(user);


        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();


        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, token)
                .body(new JwtAuthenticationResponse(
                        user.getEmail(),
                        roles.get(0),
                        token));

    }

    @Override
    public RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
            var token = jwtService.generateToken(user);
            RefreshTokenResponse response = new RefreshTokenResponse(token, refreshTokenRequest.getToken());

            return response;

        }
        return null;
    }

    @Override
    public void signout(HttpServletRequest request) {
        SecurityContextHolder.getContext().setAuthentication(null);
        jwtService.invalidateToken(request);
    }
}
