package org.geografii.config;

import org.geografii.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfig {
    @Value("${jwt.secret}")
    public String secretForLogin;
    @Value("${jwt.expiration_time}")
    public Integer jwtLifetime;

    @Bean
    public JwtTokenUtil jwtTokenUtil(final CacheManager cacheManager) {
        return new JwtTokenUtil(cacheManager, this);
    }
}
