//package com.riwi.techq.Application.Services;
//
//import com.riwi.techq.Infrastructure.Security.Filter.JwtUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthServiceImpl {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtUtils jwtTokenProvider;
//
//    @Autowired
//    private UserDetailsService userDetailsService; //
//
//    public String login(String email, String password) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
//        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
//        return jwtTokenProvider.generateToken(userDetails); // Método que genera el JWT
//    }
//}
