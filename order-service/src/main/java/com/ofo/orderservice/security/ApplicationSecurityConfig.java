package com.ofo.orderservice.security;

import static com.ofo.orderservice.security.ApplicationPermission.OFO_ADMIN;
import static com.ofo.orderservice.security.ApplicationPermission.OFO_USER;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

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
                .antMatchers(HttpMethod.POST,"/order").hasAnyAuthority(OFO_USER.name(),OFO_ADMIN.name())
                .antMatchers(HttpMethod.PUT,"/order").hasAnyAuthority(OFO_USER.name(),OFO_ADMIN.name())
                .antMatchers(HttpMethod.GET,"/order/{userId}").hasAnyAuthority(OFO_USER.name(),OFO_ADMIN.name())
                .antMatchers(HttpMethod.GET,"/order/{restaurantId}").hasAnyAuthority(OFO_USER.name(),OFO_ADMIN.name())
                .antMatchers(HttpMethod.GET,"/order/{orderId}").hasAnyAuthority(OFO_USER.name(),OFO_ADMIN.name())
                .anyRequest()
                .authenticated();
    }
}
