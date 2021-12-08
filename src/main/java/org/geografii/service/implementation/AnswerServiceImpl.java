package org.geografii.service.implementation;

import org.geografii.dto.AnswerModelDTO;
import org.geografii.mapstruct.AnswerMapper;
import org.geografii.mapstruct.AnswerMapperImpl;
import org.geografii.repository.AnswerRepository;
import org.geografii.service.AnswerService;
import org.springframework.transaction.annotation.Transactional;

public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    public AnswerServiceImpl(AnswerRepository answerRepository, AnswerMapper answerMapper) {
        this.answerRepository = answerRepository;
        this.answerMapper=answerMapper;
    }

    @Override
    @Transactional
    public AnswerModelDTO saveAnswer(AnswerModelDTO answerModelDTO) {
        return answerMapper.answerModelToAnswerDTO(this.answerRepository.save(this.answerMapper.answerDTOToAnswerModel(answerModelDTO)));
    }

    @Override
    public AnswerModelDTO getAnswerById(Long id) {
        return this.answerMapper.answerModelToAnswerDTO(this.answerRepository.getById(id));
    }
}
