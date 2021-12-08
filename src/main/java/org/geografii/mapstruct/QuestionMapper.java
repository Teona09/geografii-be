package org.geografii.mapstruct;

import org.geografii.dto.QuestionModelDTO;
import org.geografii.model.QuestionModel;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface QuestionMapper {
    QuestionModel questionDTOToQuestionModel(QuestionModelDTO questionModelDTO);

    QuestionModelDTO questionModelToQuestionDTO(QuestionModel questionModel);

    Set<QuestionModel> questionDTOSetToQuestionModelSet(Set<QuestionModelDTO> questionModelDTO);

    Set<QuestionModelDTO> questionModelSetToQuestionDTOSet(Set<QuestionModel> questionModel);
}
