package org.geografii.service.security;

import org.geografii.dto.LoginDTO;
import org.geografii.dto.TokenDTO;
import org.geografii.model.UserDetailsImpl;
import org.geografii.util.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AuthenticationServiceImpl implements AuthenticationService{
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthenticationServiceImpl(UserDetailsService userDetailsService, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public TokenDTO loginUser(LoginDTO loginDTO) {
        authenticate(loginDTO.getEmail(), loginDTO.getPassword());

        final UserDetailsImpl userDetailsImpl = (UserDetailsImpl) userDetailsService.loadUserByUsername(loginDTO.getEmail());
        return jwtTokenUtil.generateLoginToken(userDetailsImpl);
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
