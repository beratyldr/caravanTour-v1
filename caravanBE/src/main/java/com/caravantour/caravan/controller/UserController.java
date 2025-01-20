package com.caravantour.caravan.controller;

import com.caravantour.caravan.model.dto.UserDTO;
import com.caravantour.caravan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/current-user")
    public ResponseEntity<?> getCurrentUser() {
        UserDTO user = userService.getCurrentUser();
        return Objects.isNull(user) ? ResponseEntity.ok("anonymousUser kullanıcı") : ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello user");
    }
}
