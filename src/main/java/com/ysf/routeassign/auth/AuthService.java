package com.ysf.routeassign.auth;

import com.ysf.routeassign.security.JwtService;
import com.ysf.routeassign.user.UserDAO;
import com.ysf.routeassign.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.username(),
                        authenticationRequest.password()
                )
        );

        UserDAO user = userRepository.findOneByUsername(authenticationRequest.username()).orElseThrow();

        String token = jwtService.generateToken(user.getUsername());

        return AuthenticationResponse.builder().token(token).build();
    }
}
