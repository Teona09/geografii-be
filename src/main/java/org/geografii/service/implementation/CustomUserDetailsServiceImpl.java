package org.geografii.service.implementation;

import org.geografii.exception.CustomException;
import org.geografii.service.CustomUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    @Override
    public Optional<String> getUserDetails() {
        if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof String) {
            return Optional.of((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }
        return Optional.empty();
    }

    @Override
    public String getUserDetailsOrThrow() throws CustomException {
        return getUserDetails().orElseThrow(() -> new CustomException("No one logged in", HttpStatus.NOT_FOUND));
    }
}
