package org.geografii.service;

import org.geografii.dto.UserModelDTO;
import org.geografii.exception.CustomException;

public interface UserService {
    UserModelDTO registerUser(UserModelDTO userModelDTO) throws CustomException;

    boolean existsByEmail(String email);

    UserModelDTO getById(Long id) throws CustomException;

    UserModelDTO getByEmail(String email) throws CustomException;

    void resetPassword(Long id,String password) throws CustomException;

    void deleteAccount(Long id) throws CustomException;

    UserModelDTO updateUser(UserModelDTO user) throws CustomException;
}
