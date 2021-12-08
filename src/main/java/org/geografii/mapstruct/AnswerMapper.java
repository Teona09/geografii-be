package org.geografii.mapstruct;

import org.geografii.dto.AnswerModelDTO;
import org.geografii.model.AnswerModel;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface AnswerMapper {
    AnswerModel answerDTOToAnswerModel(AnswerModelDTO answerModelDTO);

    AnswerModelDTO answerModelToAnswerDTO(AnswerModel answerModel);

    Set<AnswerModel> answerDTOSetToAnswerModelSet(Set<AnswerModelDTO> answerModelDTO);

    Set<AnswerModelDTO> answerModelSetToAnswerDTOSet(Set<AnswerModel> answerModel);
}
