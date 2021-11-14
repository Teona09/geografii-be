package org.geografii.security;

import org.geografii.model.RoleModel;
import org.geografii.model.UserModel;
import org.geografii.repository.RoleRepository;
import org.geografii.repository.UserRepository;
import org.geografii.service.CustomUserDetailsService;

public class UserAccessHandlerImpl implements UserAccessHandler{
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final CustomUserDetailsService customUserDetailsService;

    public UserAccessHandlerImpl(RoleRepository roleRepository, UserRepository userRepository, CustomUserDetailsService customUserDetailsService) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public boolean canSearchRole(int id) throws Exception {
        return isRoleOwner(id);
    }

    /**
     * Determines whether the role with that id belongs to the logged in user
     * @param id The id of the role
     * @return True if it is the role of the user, otherwise false
     * @throws Exception If there is no logged in user
     */
    private boolean isRoleOwner(int id) throws Exception{
        UserModel user=userRepository.findByEmail(customUserDetailsService.getUserDetailsOrThrow()).orElseThrow(()->{
            return new Exception("User not found");
        });
        for(RoleModel r : user.getRoleModels()){
            if(r.getId()==id){
                return true;
            }
        }
        return false;
    }
}
