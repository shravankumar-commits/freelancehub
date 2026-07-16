package com.freelancehub.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter
{
	@Autowired
	private Jwtutil jwtUtil;
	 @Override
	 protected void doFilterInternal(HttpServletRequest request,
	            HttpServletResponse response,
	            FilterChain filterChain)
	            throws ServletException, IOException {
	 
		 String authHeader = request.getHeader("Authorization");
	 
	 String jwt=null;
	 
	 if(authHeader !=null&& authHeader.startsWith("Bearer ")) 
	 {
		 jwt = authHeader.substring(7);
		 String email = jwtUtil.extractEmail(jwt);
		 System.out.println("Email from Jwt = " + email);
	 }
	 	filterChain.doFilter(request,response);
	 }
}
