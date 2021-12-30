package com.proyecto.arriendo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.proyecto.arriendo.service.UsuarioService;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		return bcpe;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userService).passwordEncoder(encoder);		
	}
	
	private AuthenticationSuccessHandler handler;
	
	@Autowired
	public void webSecurityConfig(AuthenticationSuccessHandler handler)
	{
		this.handler = handler;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
		.authorizeRequests()
		.antMatchers("/","/index","/registro","/registro/agregar","/index/buscar","index","/index","/resumen").permitAll()
		.antMatchers("/css/**", "/img/**", "/js/**","/scss/**","/vendor/**").permitAll()
		.antMatchers("/reserva")
		.hasAnyAuthority("3")
		.antMatchers("/admin","/admin/**")
		.hasAnyAuthority("1")
		.antMatchers("/fun","/fun/**")
		.hasAnyAuthority("2")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin().loginPage("/login")
		.successHandler(handler)
		.permitAll()
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/");
	}
	
	
}
