package com.ofo.searchservice.security;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	    @Override
	    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
	        String key = "thisneedstobelongforittobesecure";
	        String token = Jwts.builder()
	                .setSubject(authResult.getName())
	                .claim("authorities",authResult.getAuthorities())
	                .setIssuedAt(new Date())
	                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(2)))
	                .signWith(Keys.hmacShaKeyFor(key.getBytes()))
	                .compact();
	     //   response.addHeader("authorization","Bearer "+token);
	          response.addHeader("authorization",token);
	    }
}
