package com.example.configwebapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RefreshScope
@RequestMapping("user")
@RestController
public class UserController {

    @Value("${app.username}")
    private String secretUsername;

    @Value("${app.email}")
    private String secretEmail;

    @GetMapping
    public Map<String, String> getUser() {
        return Map.of("username", secretUsername,
                "email", secretEmail);
    }
}
