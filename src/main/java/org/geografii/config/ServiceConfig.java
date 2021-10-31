package org.geografii.config;

import org.geografii.mapstruct.AnswerMapper;
import org.geografii.repository.AnswerRepository;
import org.geografii.service.AnswerService;
import org.geografii.service.implementation.AnswerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public AnswerService answerService(final AnswerRepository answerRepository, final AnswerMapper answerMapper) {
        return new AnswerServiceImpl(answerRepository, answerMapper);
    }
}
