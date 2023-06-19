package com.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@Deprecated 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	 	@Bean
	    public PasswordEncoder getPasswordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
	    }
	 
	 @Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			//auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
			auth.userDetailsService(userDetailsService);
	 }
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		System.out.println("**********I am in Security Configuration method********");
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/api/getmessage/**").hasRole("ADMIN")
		.antMatchers("/api/getdisplay/**").hasRole("USER")
		.anyRequest()
		.fullyAuthenticated()
		.and().formLogin().and().httpBasic();
		}

}
