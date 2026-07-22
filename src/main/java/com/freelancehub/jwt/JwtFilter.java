package com.freelancehub.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.freelancehub.service.CustomUserDetailsService;

@Component
public class JwtFilter extends OncePerRequestFilter
{
	@Autowired
	private Jwtutil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	 protected void doFilterInternal(HttpServletRequest request,
	            HttpServletResponse response,
	            FilterChain filterChain)
	            throws ServletException, IOException {
	 
		 String authHeader = request.getHeader("Authorization");
	 
	 String jwt=null;
	 if (request.getServletPath().equals("/login")) {
		    filterChain.doFilter(request, response);
		    return;
		}
	 
	 if(authHeader !=null&& authHeader.startsWith("Bearer ")) 
	 {
		 jwt = authHeader.substring(7);
		 String email = jwtUtil.extractEmail(jwt);
		 System.out.println("Email from Jwt = " + email);
		 
		 UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
		 UsernamePasswordAuthenticationToken authentication =
			        new UsernamePasswordAuthenticationToken(
			                userDetails,
			                null,
			                userDetails.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println("Authentication Stored Successfully");
			System.out.println("Authorities = " + userDetails.getAuthorities());
	 }
	 	filterChain.doFilter(request,response);
	 }
}
