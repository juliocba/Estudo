package com.uni7.estudo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class InMemorySecurityConfig {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("julio").password("123").roles("USER").and().withUser("cesar")
				.password("123").roles("USER").and().withUser("lucas").password("123").roles("USER");
	}
}