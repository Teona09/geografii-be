package org.geografii.mapstruct;

import org.geografii.dto.LevelModelDTO;
import org.geografii.model.LevelModel;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface LevelMapper {
    LevelModel levelDTOToLevelModel(LevelModelDTO levelModelDTO);

    LevelModelDTO levelModelToLevelDTO(LevelModel levelModel);

    Set<LevelModel> levelDTOSetToLevelModelSet(Set<LevelModelDTO> levelModelDTO);

    Set<LevelModelDTO> levelModelSetToLevelDTOSet(Set<LevelModel> levelModel);
}
