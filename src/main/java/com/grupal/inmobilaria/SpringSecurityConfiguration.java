package com.grupal.inmobilaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.grupal.inmobilaria.security.LoginSuccessHandler;
import com.grupal.inmobilaria.service.UsuarioService;

@Configuration
public class SpringSecurityConfiguration  extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private LoginSuccessHandler handler;
	
		
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
		
	@Autowired //Authetication
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{	
		build.userDetailsService(service).passwordEncoder(encoder());		
	}
	
	@Override //Autorization
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/","/admin/css/**","/admin/img/**","/admin/js/**","/admin/scss/**","/admin/vendor/**","/assets/**","/css/**","/js/**").permitAll()
			.antMatchers("/usuario/create","/usuario/save","/inmobilaria/**").anonymous()
			.antMatchers("/usuario/**","/empresa/**").hasAnyRole("USER")
			.antMatchers("/alumno/**").hasAnyRole("USER")			
			.antMatchers("/h2-console/**").anonymous()
			.anyRequest().authenticated()
			.and().formLogin().successHandler(handler).loginPage("/login").permitAll()			
			.and().logout().permitAll()			
			.and().exceptionHandling().accessDeniedPage("/error_403")
			.and()
				.csrf().ignoringAntMatchers("/h2-console/**")
			.and()
				.headers().frameOptions().sameOrigin();
	}
	
	
	
}
