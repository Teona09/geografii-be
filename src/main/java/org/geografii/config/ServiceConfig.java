package org.geografii.config;

import org.geografii.mapstruct.AnswerMapper;
import org.geografii.mapstruct.LevelMapper;
import org.geografii.mapstruct.QuestionMapper;
import org.geografii.repository.AnswerRepository;
import org.geografii.repository.LevelRepository;
import org.geografii.repository.QuestionRepository;
import org.geografii.service.AnswerService;
import org.geografii.service.LevelService;
import org.geografii.service.QuestionService;
import org.geografii.service.implementation.AnswerServiceImpl;
import org.geografii.service.implementation.LevelServiceImpl;
import org.geografii.service.implementation.QuestionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public AnswerService answerService(final AnswerRepository answerRepository, final AnswerMapper answerMapper) {
        return new AnswerServiceImpl(answerRepository, answerMapper);
    }

    @Bean
    public QuestionService questionService(final QuestionRepository questionRepository, final QuestionMapper
            questionMapper, final AnswerRepository answerRepository) {
        return new QuestionServiceImpl(questionRepository, questionMapper, answerRepository);
    }

    @Bean
    public LevelService levelService(final LevelRepository levelRepository, final LevelMapper levelMapper) {
        return new LevelServiceImpl(levelRepository, levelMapper);
    }
}
