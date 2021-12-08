package org.geografii.service;

import org.geografii.dto.InformationModelDTO;
import org.geografii.dto.LevelModelDTO;
import org.geografii.dto.QuestionModelDTO;

import java.util.List;
import java.util.Set;

public interface LevelService {
    LevelModelDTO saveLevel(LevelModelDTO levelModelDTO);

    LevelModelDTO getLevelById(Long id);

    List<LevelModelDTO> getAllLevels();

    LevelModelDTO deleteLevel(Long levelId);

    LevelModelDTO updateLevel(LevelModelDTO newLevelModelDTO);
}
