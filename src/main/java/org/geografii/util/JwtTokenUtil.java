package org.geografii.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.geografii.config.UtilConfig;
import org.geografii.dto.TokenDTO;
import org.geografii.exception.CustomException;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.cache.annotation.Cacheable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtTokenUtil {
    public static final String TOKEN_CACHE_NAME = "token";
    private final String secretForLogin;
    private final Integer jwtLifetime;
    private final CacheManager cacheManager;
    private final UtilConfig utilConfig;


    public JwtTokenUtil(String secretForLogin, Integer jwtLifetime, CacheManager cacheManager, UtilConfig utilConfig) {
        this.secretForLogin = secretForLogin;
        this.jwtLifetime = jwtLifetime;
        this.cacheManager = cacheManager;
        this.utilConfig = utilConfig;
    }

    public JwtTokenUtil(CacheManager cacheManager, UtilConfig utilConfig) {
        this.cacheManager = cacheManager;
        this.utilConfig = utilConfig;
        this.secretForLogin = utilConfig.secretForLogin;
        this.jwtLifetime = utilConfig.jwtLifetime;
    }

    public enum TokenType {
        LOGIN
    }

    public String getIdFromToken(String token, TokenType tokenType) throws CustomException {
        return getClaimFromToken(token, Claims::getSubject, tokenType);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver, TokenType tokenType) throws CustomException {
        final Claims claims = getAllClaimsFromToken(token, tokenType);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token, TokenType tokenType) throws CustomException {
        if (tokenType.equals(TokenType.LOGIN)) {
            return Jwts.parser()
                    .setSigningKey(secretForLogin)
                    .parseClaimsJws(token)
                    .getBody();
        }
        throw new CustomException("Invalid token type");
    }

    @Cacheable(value = TOKEN_CACHE_NAME, key = "#userDetails.username")
    public TokenDTO generateLoginToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        return new TokenDTO(buildTokenForLogin(claims, userDetails.getUsername(), userDetails), userDetails.getUsername(), userDetails, new Date());
    }

    private String buildTokenForLogin(Map<String, Object> claims, String subject, UserDetails userDetails) {
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withSubject(subject)
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtLifetime))
                .sign(Algorithm.HMAC512(secretForLogin.getBytes()));
    }

    public boolean isLoginTokenExpired(String id) {
        Cache.ValueWrapper tokenValueWrapper = cacheManager.getCache(TOKEN_CACHE_NAME).get(id);
        if (tokenValueWrapper == null) {
            return true;
        }
        Date lastModified = ((TokenDTO) tokenValueWrapper.get()).getLastModified();
        return new Date().getTime() - lastModified.getTime() > jwtLifetime;
    }

    public UserDetails getLoggedInUserDetails(String email) {
        return ((TokenDTO) cacheManager.getCache(TOKEN_CACHE_NAME)
                .get(email)
                .get())
                .getUserDetails();
    }
}
