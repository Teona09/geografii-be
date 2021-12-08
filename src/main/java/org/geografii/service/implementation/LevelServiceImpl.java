package org.geografii.service.implementation;

import org.geografii.dto.LevelModelDTO;
import org.geografii.exception.CustomException;
import org.geografii.mapstruct.LevelMapper;
import org.geografii.model.LevelModel;
import org.geografii.repository.LevelRepository;
import org.geografii.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;
    private final LevelMapper levelMapper;

    public LevelServiceImpl(LevelRepository levelRepository, LevelMapper levelMapper) {
        this.levelRepository = levelRepository;
        this.levelMapper = levelMapper;
    }

    @Override
    @Transactional
    public LevelModelDTO getLevelById(Long id) {
        Optional<LevelModel> levelModel = levelRepository.findById(id);
        if (levelModel.isEmpty())
            throw new CustomException("Level id does not exist!", HttpStatus.NOT_FOUND);
        return levelMapper.ModelToDTO(levelModel.get());
    }

    @Override
    @Transactional
    public List<LevelModelDTO> getAllLevels() {
        List<LevelModelDTO> levelModelDTOs = new ArrayList<>();
        for (var levelModel : levelRepository.findAll()) {
            levelModelDTOs.add(levelMapper.ModelToDTO(levelModel));
        }
        return levelModelDTOs;
    }

    @Override
    @Transactional
    public LevelModelDTO saveLevel(LevelModelDTO levelModelDTO) {
        LevelModel levelModel = levelMapper.DTOToModel(levelModelDTO);
        if (levelRepository.existsById(levelModelDTO.getLevelId()))
            throw new CustomException("The cnp already exists", HttpStatus.CONFLICT);
        return levelMapper.ModelToDTO(levelRepository.save(levelModel));
    }

    @Override
    @Transactional
    public LevelModelDTO deleteLevel(Long levelId) {
        Optional<LevelModel> levelModel = levelRepository.findById(levelId);
        if (levelModel.isPresent()) {
            levelRepository.delete(levelModel.get());
            return levelMapper.ModelToDTO(levelModel.get());
        } else throw new CustomException("The Student id does not exist", HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public LevelModelDTO updateLevel(LevelModelDTO newLevelModelDTO) {
        Optional<LevelModel> oldLevelModel = levelRepository.findById(newLevelModelDTO.getLevelId());
        if (oldLevelModel.isEmpty())
            throw new CustomException("Level id does not exist!", HttpStatus.NOT_FOUND);
        LevelModel levelToUpdate = oldLevelModel.get();
        levelMapper.update(levelToUpdate, newLevelModelDTO);
        return levelMapper.ModelToDTO(levelRepository.save(levelToUpdate));
    }
}
