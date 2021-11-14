package org.geografii.service;

import org.geografii.exception.CustomException;

import java.util.Optional;

public interface CustomUserDetailsService {
    Optional<String> getUserDetails();

    String getUserDetailsOrThrow() throws CustomException;
}
