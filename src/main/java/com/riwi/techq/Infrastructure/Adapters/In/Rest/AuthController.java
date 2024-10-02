package com.riwi.techq.Infrastructure.Adapters.In.Rest;

import com.riwi.techq.Infrastructure.Adapters.In.Rest.Dto.AuthRequest;
import com.riwi.techq.Infrastructure.Security.Filter.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtTokenProvider;
    @PostMapping("/login")
    public String login() {
        // Retorna una respuesta estática para pruebas
        return "Login endpoint is working!";
    }


    }
