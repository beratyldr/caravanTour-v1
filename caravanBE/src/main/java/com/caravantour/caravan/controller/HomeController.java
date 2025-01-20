package com.caravantour.caravan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/home")
public class HomeController {
    @GetMapping("/")
    public String greeting() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @GetMapping("/")
//    public ResponseEntity<String> greeting() {
//        return ResponseEntity.ok("Anasayfa");
//    }
//    @GetMapping("/login")
//    public ResponseEntity<String> login() {
//        return ResponseEntity.ok("Login Page");
//    }
}