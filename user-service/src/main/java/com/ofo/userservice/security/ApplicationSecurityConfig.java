package com.ofo.userservice.security;

import static com.ofo.userservice.security.ApplicationPermission.OFO_ADMIN;
import static com.ofo.userservice.security.ApplicationPermission.OFO_USER;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


/**
 * This class has the configuration and security rules added to all end points supported by this availability services
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterAfter(new JWTTokenVerifier(),JWTAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/users").hasAnyAuthority(OFO_USER.name())
                .antMatchers(HttpMethod.GET,"users/{userId}").hasAnyAuthority(OFO_USER.name())
                .antMatchers(HttpMethod.PUT,"users/{userId}s").hasAnyAuthority(OFO_USER.name())
                .antMatchers(HttpMethod.DELETE,"users/{userId}}").hasAnyAuthority(OFO_USER.name())
                .anyRequest()
                .authenticated();
    }
}
