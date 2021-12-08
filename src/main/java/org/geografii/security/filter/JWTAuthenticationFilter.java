package org.geografii.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geografii.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.geografii.dto.TokenDTO;
import org.geografii.exception.CustomException;
import org.geografii.model.UserModel;
import org.geografii.util.JwtTokenUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final ObjectMapper objectMapper;
    private final JwtTokenUtil jwtTokenUtil;
    public String secretForLogin;
    public Long jwtLifetime;
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, String secretForLogin, Long jwtLifetime) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/users/login");
        this.objectMapper = new ObjectMapper();
        this.jwtTokenUtil = jwtTokenUtil;
        this.secretForLogin = secretForLogin;
        this.jwtLifetime = jwtLifetime;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException, CustomException {
        try {
            UserModel userModel = objectMapper.readValue(req.getInputStream(), UserModel.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userModel.getEmail(),
                            userModel.getPassword(),
                            userModel.getRoleModels()
                                    .stream()
                                    .map(roleModel -> new SimpleGrantedAuthority(roleModel.getName()))
                                    .collect(Collectors.toSet())));
        } catch (IOException | JWTDecodeException e) {
            throw new CustomException(e.getMessage());
        }
    }

//    @Override
//    protected void successfulAuthentication(HttpServletRequest req,
//                                            HttpServletResponse res,
//                                            FilterChain chain,
//                                            Authentication auth) throws IOException {
//
//        TokenDTO tokenDTO = jwtTokenUtil.generateLoginToken((UserDetails) auth.getPrincipal());
//        res.getWriter().write(tokenDTO.toString());
//        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        res.getWriter().flush();
//    }
@Override

protected void successfulAuthentication(HttpServletRequest req,

                                        HttpServletResponse res,

                                        FilterChain chain,

                                        Authentication auth) throws IOException {

    String token = JWT.create()

            .withSubject(((UserDetailsImpl) auth.getPrincipal()).getUsername())

            .withExpiresAt(new Date(System.currentTimeMillis() + jwtLifetime))

            .sign(Algorithm.HMAC512(secretForLogin.getBytes()));

    TokenDTO responseDTO = new TokenDTO(token, ((UserDetailsImpl) auth.getPrincipal()).getUsername(), ((UserDetailsImpl) auth.getPrincipal()), System.currentTimeMillis());

    res.getWriter().write(objectMapper.writer()

            .withDefaultPrettyPrinter()

            .writeValueAsString(responseDTO));

    res.getWriter().flush();

}
}
