package org.geografii.mapstruct;

import org.geografii.dto.LevelModelDTO;
import org.geografii.model.LevelModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper
public interface LevelMapper {
    LevelModel DTOToModel(LevelModelDTO levelModelDTO);

    LevelModelDTO ModelToDTO(LevelModel levelModel);

    Set<LevelModel> DTOSetToModelSet(Set<LevelModelDTO> levelModelDTO);

    Set<LevelModelDTO> ModelSetToDTOSet(Set<LevelModel> levelModel);

    void update(@MappingTarget LevelModel levelModel, LevelModelDTO levelModelDTO);
}
