package org.geografii.mapstruct;

import org.geografii.dto.UserModelDTO;
import org.geografii.model.UserModel;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface UserMapper {
    UserModel userDTOToUserModel(UserModelDTO userModelDTO);

    UserModelDTO userModelToUserDTO(UserModel userModel);

    Set<UserModel> userDTOSetToUserModelSet(Set<UserModelDTO> userModelDTO);

    Set<UserModelDTO> userModelSetToUserDTOSet(Set<UserModel> userModel);
}
