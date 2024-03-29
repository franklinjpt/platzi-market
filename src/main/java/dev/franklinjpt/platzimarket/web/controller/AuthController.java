package dev.franklinjpt.platzimarket.web.controller;

import dev.franklinjpt.platzimarket.domain.dto.AuthenticationRequest;
import dev.franklinjpt.platzimarket.domain.dto.AuthenticationResponse;
import dev.franklinjpt.platzimarket.domain.service.PlatziUserDetailsService;
import dev.franklinjpt.platzimarket.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;

    private PlatziUserDetailsService platziUserDetailsService;

    private JWTUtil jwtUtil;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, PlatziUserDetailsService platziUserDetailsService, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.platziUserDetailsService = platziUserDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createtoken(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = platziUserDetailsService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
