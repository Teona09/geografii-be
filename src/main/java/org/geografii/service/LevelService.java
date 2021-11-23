package org.geografii.service;

import org.geografii.dto.LevelModelDTO;
import org.geografii.model.InformationModel;
import org.geografii.model.QuestionModel;

import java.util.List;
import java.util.Set;

public interface LevelService {
    void saveLevel(LevelModelDTO levelModelDTO);

    LevelModelDTO getLevelById(Long id);

    List<LevelModelDTO> getAllLevels();

    void deleteLevel(Long levelId);

    void updateLevel(Long levelId, String region, Integer maximumPoints, Set<InformationModel> informationModels,
                     Set<QuestionModel> questionModels);
}
