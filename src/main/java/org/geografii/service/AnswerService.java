package org.geografii.service;

import org.geografii.dto.AnswerModelDTO;

public interface AnswerService {
    void saveAnswer(AnswerModelDTO answerModelDTO);

    AnswerModelDTO getAnswerById(Long id);
}
