package org.geografii.config;

import org.geografii.mapstruct.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public AnswerMapper answerMapper() {
        return new AnswerMapperImpl();
    }

    @Bean
    public InformationMapper informationMapper() {
        return new InformationMapperImpl();
    }

    @Bean
    public LevelMapper levelMapper() {
        return new LevelMapperImpl();
    }

    @Bean
    public QuestionMapper questionMapper() {
        return new QuestionMapperImpl();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }
}
