package com.app.twitterClone.service;

import com.app.twitterClone.config.jwt.JwtService;
import com.app.twitterClone.model.User;
import com.app.twitterClone.model.dto.LoginRequest;
import com.app.twitterClone.model.dto.LoginResponse;
import com.app.twitterClone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtService jwtService;



    public LoginResponse login(LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        String token = jwtService.getToken(user);

        User userTotal = userRepository.findByUsername(request.getUsername()).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado"));

        return LoginResponse.builder()
                .username(userTotal.getUsername())
                .nombre(userTotal.getNombre())
                .apellido(userTotal.getApellido())
                .token(token)
                .build();
    }


    public User register(User user){
        User userSave = User.builder()
                .username(user.getUsername())
                .nombre(user.getNombre())
                .apellido(user.getApellido())
                .password(passwordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .build();

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Ya existe ese usuario");
        }


        return userRepository.save(userSave);
    }
}
