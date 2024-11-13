package com.app.twitterClone.controller;


import com.app.twitterClone.model.User;
import com.app.twitterClone.model.dto.LoginRequest;
import com.app.twitterClone.model.dto.LoginResponse;
import com.app.twitterClone.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return authService.register(user);
    }
}
