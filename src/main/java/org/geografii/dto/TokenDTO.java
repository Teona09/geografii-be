package org.geografii.dto;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class TokenDTO {
    private String token;
    private String email;
    private UserDetails userDetails;
    private Long lastModified;

    public TokenDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    public TokenDTO(String token, String email, UserDetails userDetails, Long lastModified) {
        this.token = token;
        this.email = email;
        this.userDetails = userDetails;
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return String.format("{" +
                "\"token\":\"" + token + "\"" +
                ", \"email\":\"" + email + "\"}");
    }
}
