package com.ucamp.dorothy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ucamp.dorothy.common.security.CustomLoginSuccessHandler;
import com.ucamp.dorothy.service.MemberService;
import com.ucamp.dorothy.service.SecurityService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final SecurityService securityService;
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/fonts/**","/images/**","/js/**","/vendor/**");
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(securityService).passwordEncoder(passwordEncoder());
    }

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
    @Bean // 패스워드 암호화 관련 메소드
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }    
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("security config...");

		http.rememberMe()
			.key("dorothygood!")
			.rememberMeParameter("remember-me")
			.tokenValiditySeconds(86400*30)
			.userDetailsService(securityService);
		
		http.exceptionHandling()
			.accessDeniedPage("/accessError");
		
		http.logout()
		    .logoutUrl("/logout")
		    .invalidateHttpSession(true);
		
		http.formLogin()
			.loginPage("/login")
			.successHandler(authenticationSuccessHandler());
	}
}
