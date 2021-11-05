package org.geografii.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity

@Configuration
public class BasicAuthSecurityConfig extends WebSecurityConfigurerAdapter {

    public BasicAuthSecurityConfig() {
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .formLogin().disable()

                .httpBasic().and()

                .authorizeRequests()

                .antMatchers("/**").permitAll();
    }
}