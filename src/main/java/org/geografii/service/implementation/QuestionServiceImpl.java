package org.geografii.service.implementation;

import org.geografii.dto.QuestionModelDTO;
import org.geografii.mapstruct.QuestionMapper;
import org.geografii.model.AnswerModel;
import org.geografii.model.QuestionModel;
import org.geografii.repository.AnswerRepository;
import org.geografii.repository.QuestionRepository;
import org.geografii.service.QuestionService;
import org.springframework.transaction.annotation.Transactional;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final AnswerRepository answerRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, QuestionMapper questionMapper, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.questionMapper=questionMapper;
        this.answerRepository = answerRepository;
    }

    @Override
    @Transactional
    public void saveQuestion(QuestionModelDTO questionModelDTO) {
        QuestionModel question= this.questionMapper.questionDTOToQuestionModel((questionModelDTO));
        AnswerModel ans = this.answerRepository.getById(Long.parseLong("1"));
        question.addAnswer(ans);
        this.questionRepository.save(this.questionMapper.questionDTOToQuestionModel(questionModelDTO));
    }
}
