package org.geografii.service.implementation;

import org.geografii.dto.UserModelDTO;
import org.geografii.exception.CustomException;
import org.geografii.mapstruct.UserMapper;
import org.geografii.model.RoleModel;
import org.geografii.model.UserModel;
import org.geografii.repository.RoleRepository;
import org.geografii.repository.UserRepository;
import org.geografii.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserModelDTO registerUser(UserModelDTO userModelDTO) throws CustomException {
        if (userRepository.existsByEmailIgnoreCase(userModelDTO.getEmail())) {
            throw new CustomException("Email already exists!", HttpStatus.CONFLICT);
        }
        Optional<RoleModel> role = roleRepository.findByNameIgnoreCase(userModelDTO.getRoleModel());
        if (role.isEmpty()) {
            throw new CustomException("Role does not exist!", HttpStatus.NOT_FOUND);
        }
        UserModel user = userMapper.userDTOToUserModel(userModelDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleModels(new HashSet<>());
        user.addRole(role.get());
        user.setUsablePoints(0L);
        UserModel addedUser = userRepository.save(user);
        return userMapper.userModelToUserDTO(addedUser);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }

    @Override
    public UserModelDTO getById(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserModel u = user.get();
            UserModelDTO usr = userMapper.userModelToUserDTO(u);
            usr.setRoleModel(u.getRoleModels().stream().findFirst().get().getName());
            return usr;
        } else {
            throw new CustomException("no user found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public void resetPassword(Long id, String password) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserModel u = user.get();
            u.setPassword(passwordEncoder.encode(password));
            userRepository.save(u);
        } else {
            throw new CustomException("no user found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public void deleteAccount(Long id) throws CustomException {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserModel u = user.get();
            userRepository.delete(u);
        } else {
            throw new CustomException("no user found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public UserModelDTO updateUser(UserModelDTO userModelDTO) throws CustomException {
        Optional<UserModel> user = userRepository.findById(userModelDTO.getUserId());
        if (user.isPresent()) {
            UserModel u = user.get();
            u.setFirstName(userModelDTO.getFirstName());
            u.setLastName(userModelDTO.getLastName());
            u.setEmail(userModelDTO.getEmail());
            return userMapper.userModelToUserDTO(userRepository.save(u));
        } else {
            throw new CustomException("no user found", HttpStatus.NOT_FOUND);
        }
    }
}
