package com.ofo.restaurantservice.security;

import static com.ofo.restaurantservice.security.ApplicationPermission.OFO_ADMIN;
import static com.ofo.restaurantservice.security.ApplicationPermission.OFO_USER;

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
                .antMatchers(HttpMethod.POST,"/restaurant").hasAuthority(OFO_ADMIN.name())
                .antMatchers(HttpMethod.PUT,"/restaurant/").hasAuthority(OFO_ADMIN.name())
                .antMatchers(HttpMethod.PUT,"/restaurant/updatemenu").hasAuthority(OFO_ADMIN.name())
                .antMatchers(HttpMethod.GET,"/restaurant/{restaurantId}").hasAnyAuthority(OFO_USER.name(),OFO_ADMIN.name())
                .antMatchers(HttpMethod.GET,"/restaurant/rating").hasAnyAuthority(OFO_USER.name(),OFO_ADMIN.name())
                .anyRequest()
                .authenticated();
    }
}
