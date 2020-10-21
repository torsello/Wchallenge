package com.wolox.socialnetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.wolox.socialnetwork.security.JWTAuthorizationFilter;

@SpringBootApplication
public class SocialnetworkApplication {

	private static final String[] AUTH_WHITELIST = { "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs",
			"/webjars/**" };

	public static void main(String[] args) {
		SpringApplication.run(SocialnetworkApplication.class, args);
	}

	@Autowired
	private JWTAuthorizationFilter jwtFilter;
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests().antMatchers(HttpMethod.GET, "/api/login").permitAll()
					.antMatchers(AUTH_WHITELIST).permitAll().anyRequest().authenticated();
		}
	}

}
