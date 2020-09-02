package com.health.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import com.health.service.impl.UserSecurityService;
import com.health.utility.SecurityUtility;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private Environment env;

	@Autowired
	private UserSecurityService userSecurityService;

	private BCryptPasswordEncoder passwordEncoder() {
		return SecurityUtility.passwordEncoder();
	}

	private static final String[] PUBLIC_MATCHERS = {
			"/css/**",
			"/js/**",
			"/image/**",
			"/",
			"/newUser",
			"/Media/**",
			"/forgetPassword",
			"/feedcustomerdat",
			"/login",
			"/s/**",
			"/adminDeatail/**",
			"/loadByCategoryTuturial",
			"/ControllerHealth",
			"/showTutorial",
			"/findTutorialByLanand",
			"/showListTutorial",
			"/showVideoWithContained",
			"/showListOfTutorial",
			"/showListTutorial",
			"/viewVideo/view/{id}",
			"viewVideoList/view/{id}",
			"/fonts/**"	
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		
		.headers()
			.frameOptions().sameOrigin()
			.httpStrictTransportSecurity().disable();
		http
		// ...
		.headers()
			// do not use any default headers unless explicitly listed
			.defaultsDisabled()
			.cacheControl();
		
		   http
		      // ...
		   .headers().disable();
		   

		   
		
		http
			.authorizeRequests()
			.antMatchers("/").hasAnyAuthority()
				/* .antMatchers("/adminDeatail/**").hasRole("Admin") */	
				/* .antMatchers("/userDetail/**").hasAnyAuthority("Admin") */
			.antMatchers(PUBLIC_MATCHERS).
				permitAll().anyRequest().authenticated().
				and()
				.exceptionHandling().accessDeniedPage("/access-denied");
		
			http.headers().frameOptions().disable();
		
		
		/*
		 * http
		 * 
		 * .authorizeRequests() .antMatchers("/userDetail/**").hasRole("ROLE_USER")
		 * .antMatchers("/adminDeatail/**").access("ROLE_ADMIN").anyRequest().
		 * authenticated();
		 */ 
		
		  http.
		  formLogin().
		  defaultSuccessUrl("/", true);
		 
		
		http
			.csrf().disable().cors().disable()
			.formLogin().failureUrl("/login?error")
			//("userDetail.html")
			/*.defaultSuccessUrl("/")*/
			.loginPage("/login").permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
			.and()
			.rememberMe();
	}
	
	
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
		
	}

}
