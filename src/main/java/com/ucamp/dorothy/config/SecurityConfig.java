package com.ucamp.dorothy.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ucamp.dorothy.common.security.CustomLoginSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/fonts/**","/images/**","/js/**","/vendor/**");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("security config...");

		/*
		http.authorizeRequests()
			.antMatchers("/login")
			.anonymous();
		*/
		
		// 로그인 계정 접근
		/*
		http.authorizeRequests()
			.antMatchers("/templates/**")
			.authenticated();
		*/
		
		// 어드민 계정 접근
		/*
		http.authorizeRequests()
			.antMatchers("/**")
			.hasRole("A");
		*/
		
		/*
		http.authorizeHttpRequests()
			.antMatchers("/", "/login", "/register").permitAll()
			.anyRequest().authenticated();
		*/
		
		// 접근 에러시 나오는 페이지
		http.exceptionHandling()
			.accessDeniedPage("/accessError");
		
		http.logout()
		    .logoutUrl("/logout")
		    .invalidateHttpSession(true);
		
		http.formLogin()
			.loginPage("/login")
			.successHandler(authenticationSuccessHandler());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("member")
			.password("{noop}1234")
			.roles("M");
		
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("{noop}1234")
			.roles("A");
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
    @Bean // 패스워드 암호화 관련 메소드
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
