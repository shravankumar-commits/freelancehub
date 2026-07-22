package com.freelancehub.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation .Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import  org.springframework.security.web.SecurityFilterChain;
import com.freelancehub.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration

public class SecurityConfig {
	
	@Autowired
	private JwtFilter jwtFilter;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
		
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		  http
	        .csrf(csrf -> csrf.disable())

	        .authorizeHttpRequests(auth -> auth
	           .requestMatchers("/login","/register").permitAll()
	            .requestMatchers("/users").hasAuthority("ADMIN")
	            .anyRequest().authenticated()
	        )

	        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	    return http.build();
	}
}
