package org.geografii.dto;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class TokenDTO {
    private String token;
    private String email;
    private UserDetails userDetails;
    private Date lastModified;

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

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public TokenDTO(String token, String email, UserDetails userDetails, Date lastModified) {
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
