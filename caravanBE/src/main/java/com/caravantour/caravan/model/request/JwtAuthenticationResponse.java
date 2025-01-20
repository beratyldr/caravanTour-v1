package com.caravantour.caravan.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String userName;
    private String role;
    private String token;
}
