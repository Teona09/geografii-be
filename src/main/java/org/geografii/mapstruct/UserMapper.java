package org.geografii.mapstruct;

import org.geografii.dto.LevelModelDTO;
import org.geografii.dto.UserModelDTO;
import org.geografii.model.LevelModel;
import org.geografii.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper
public interface UserMapper {
    UserModel userDTOToUserModel(UserModelDTO userModelDTO);

    UserModelDTO userModelToUserDTO(UserModel userModel);

    Set<UserModel> userDTOSetToUserModelSet(Set<UserModelDTO> userModelDTO);

    Set<UserModelDTO> userModelSetToUserDTOSet(Set<UserModel> userModel);

    void update(@MappingTarget UserModel userModel, UserModelDTO userModelDTO);
}
