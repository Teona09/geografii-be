package org.geografii.service.implementation;

import org.geografii.dto.LevelModelDTO;
import org.geografii.mapstruct.LevelMapper;
import org.geografii.model.InformationModel;
import org.geografii.model.LevelModel;
import org.geografii.model.QuestionModel;
import org.geografii.repository.LevelRepository;
import org.geografii.service.LevelService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;
    private final LevelMapper levelMapper;

    public LevelServiceImpl(LevelRepository levelRepository, LevelMapper levelMapper) {
        this.levelRepository = levelRepository;
        this.levelMapper = levelMapper;
    }

    @Override
    @Transactional
    public void saveLevel(LevelModelDTO levelModelDTO) {
        levelRepository.save(levelMapper.levelDTOToLevelModel(levelModelDTO));
    }

    @Override
    @Transactional
    public LevelModelDTO getLevelById(Long id) {
        return levelMapper.levelModelToLevelDTO(levelRepository.getById(id));
    }

    @Override
    @Transactional
    public List<LevelModelDTO> getAllLevels() {
        List<LevelModelDTO> levelModelDTOs = new ArrayList<>();
        for (var levelModel : levelRepository.findAll()) {
            levelModelDTOs.add(levelMapper.levelModelToLevelDTO(levelModel));
        }
        return levelModelDTOs;
    }

    @Override
    @Transactional
    public void deleteLevel(Long levelId) {
        levelRepository.deleteById(levelId);
    }

    @Override
    @Transactional
    public void updateLevel(Long levelId, String region, Integer maximumPoints, Set<InformationModel> informationModels,
                            Set<QuestionModel> questionModels) {
        levelRepository.save(new LevelModel(levelId, region, maximumPoints, informationModels, questionModels));
    }
}
