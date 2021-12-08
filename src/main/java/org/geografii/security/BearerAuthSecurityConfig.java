package org.geografii.security;

import org.geografii.repository.UserRepository;
import org.geografii.security.filter.JWTAuthenticationFilter;
import org.geografii.security.filter.JWTAuthorizationFilter;
import org.geografii.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BearerAuthSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.secret}")
    private String SECRET;

    @Value("${jwt.expiration_time}")
    private Long EXPIRATION_TIME;

    public BearerAuthSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, UserRepository userRepository, JwtTokenUtil jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.csrf().disable()
                .cors().and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .formLogin().disable()
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManagerBean(), jwtTokenUtil, this.SECRET, this.EXPIRATION_TIME))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(), userRepository, SECRET));
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
