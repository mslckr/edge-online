package com.edge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// use this encoder to not allow plain text passwords
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// configuration to allow basic authentication and disable CSRF
			http.csrf().disable()
			// disable CSRF support. CSRF is a vulnerability in web applications. Generally
			// we dont need CSRF
			// (https://www.owasp.org/index.php/Cross-Site_Request_Forgery_(CSRF)) in APIs
			.authorizeRequests()
			.antMatchers("/js/**", "/css/**", "/img/**", "/webjars/**", "/api/**").permitAll() // allow all webjars (bootstrap and jquery), css, images and javascript files without security
			.anyRequest().authenticated()// authorize requests only if they are successfully authenticated
			.and().httpBasic(); // also allow http basic authentication
					
					// Use basic authentication (username/password based) for all authentication purpose
		}	

		
		@Override
	    public void configure(WebSecurity web) throws Exception {
		// configuration to allow these urls accessed regardless of spring security configurations
	        web.ignoring()
	            .antMatchers(HttpMethod.OPTIONS, "/**")
	            .antMatchers("/app/**/*.{js,html}")
	            .antMatchers("/content/**")
	            .antMatchers("/swagger-ui/index.html");
	    }

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication()
			.withUser("admin")
			.password("$2a$10$o4YaL1C5Q.Je32FfccrFD.nQotX1p/hDK1TUIrtDW9pLiP0o19AIK")
			.roles("ADMIN");
		}
	}