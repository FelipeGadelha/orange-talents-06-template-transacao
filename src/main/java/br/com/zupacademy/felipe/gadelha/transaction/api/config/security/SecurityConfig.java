package br.com.zupacademy.felipe.gadelha.transaction.api.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a
            .antMatchers(HttpMethod.GET, "/v1/cards/**").hasAuthority("SCOPE_transaction-scope:read")
            .anyRequest().authenticated())
        .sessionManagement(
        		s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .csrf().disable()
//        .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}