package com.bigearblessed.smartv.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SmartvSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests().antMatchers("/resource/**").permitAll()
			.antMatchers("/wechat/**").permitAll()
			.antMatchers("dingtalk/**").permitAll()
			.antMatchers("/register").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
//				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/home")
				.failureUrl("/login?error").permitAll()
			.and()
			.logout().permitAll();
	}
	
}
