package org.geografii.config;

import org.geografii.mapstruct.AnswerMapper;
import org.geografii.mapstruct.QuestionMapper;
import org.geografii.mapstruct.UserMapper;
import org.geografii.repository.AnswerRepository;
import org.geografii.repository.QuestionRepository;
import org.geografii.repository.RoleRepository;
import org.geografii.repository.UserRepository;
import org.geografii.service.AnswerService;
import org.geografii.service.CustomUserDetailsService;
import org.geografii.service.QuestionService;
import org.geografii.service.UserService;
import org.geografii.service.implementation.AnswerServiceImpl;
import org.geografii.service.implementation.CustomUserDetailsServiceImpl;
import org.geografii.service.implementation.QuestionServiceImpl;
import org.geografii.service.implementation.UserServiceImpl;
import org.geografii.service.security.AuthenticationService;
import org.geografii.service.security.AuthenticationServiceImpl;
import org.geografii.service.security.SecurityUserDetailsService;
import org.geografii.util.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class ServiceConfig {
    @Bean
    public UserDetailsService userDetailsService(final UserRepository userRepository) {
        return new SecurityUserDetailsService(userRepository);
    }

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsServiceImpl();
    }

    @Bean
    public AnswerService answerService(final AnswerRepository answerRepository, final AnswerMapper answerMapper) {
        return new AnswerServiceImpl(answerRepository, answerMapper);
    }

    @Bean
    public QuestionService questionService(final QuestionRepository questionRepository, final QuestionMapper questionMapper, final AnswerRepository answerRepository) {
        return new QuestionServiceImpl(questionRepository, questionMapper, answerRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public AuthenticationService authenticationService(final UserDetailsService userDetailsService,
                                                       final AuthenticationManager authenticationManager, final JwtTokenUtil jwtTokenUtil) {
        return new AuthenticationServiceImpl(userDetailsService, authenticationManager, jwtTokenUtil);
    }

    @Bean
    public UserService userService(final UserRepository userRepository, final RoleRepository roleRepository, final UserMapper userMapper, final PasswordEncoder passwordEncoder) {
        return new UserServiceImpl(userRepository, roleRepository, userMapper, passwordEncoder);
    }
}
