package org.geografii.service.security;

import org.geografii.dto.LoginDTO;
import org.geografii.dto.TokenDTO;

public interface AuthenticationService {
    TokenDTO loginUser(LoginDTO loginDTO);
}