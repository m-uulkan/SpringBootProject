package peaksoft.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import peaksoft.config.JwtUtil;
import peaksoft.dto.AuthRequest;
import peaksoft.dto.UserRequest;
import peaksoft.dto.response.UserResponse;
import peaksoft.service.serviceImple.UserServiceImple;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jwt")
public class RegistrationApi {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserServiceImple userService;

    @PostMapping("/login")
    public String auth(@RequestBody AuthRequest login){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        UserDetails customUserDetails = userService.loadUserByUsername(login.getEmail());
        return jwtUtil.generatedToken(customUserDetails);
    }

    @PostMapping("/registration")
    public UserResponse saveUser(@RequestBody UserRequest userRequest){
        return userService.saveUser(userRequest);
    }

}
