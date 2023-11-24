package com.ucamp.dorothy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ucamp.dorothy.common.security.CustomLoginFailureHandler;
import com.ucamp.dorothy.common.security.CustomLoginSuccessHandler;
import com.ucamp.dorothy.service.CustomOAuth2UserService;
import com.ucamp.dorothy.service.MemberService;
import com.ucamp.dorothy.service.SecurityService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final SecurityService securityService;
	
	private final CustomOAuth2UserService customerOAuth2UserService;
	
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
	
	@Bean 
	AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomLoginFailureHandler();
	}
	
    @Bean // 패스워드 암호화 관련 메소드
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }    
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("security config...");

		// 로그인 여부 접근 제어
		http.authorizeRequests()
			.antMatchers("/login", "/register", "/resetPassword", "/members/register/**", "/members/email/**", "/members/sms/**").permitAll()
			.anyRequest().authenticated();
		
		// 로그인 유지 기능
		http.rememberMe()
			.key("dorothygood!")
			.rememberMeParameter("remember-login")
			.tokenValiditySeconds(86400*30) // 한달
			.userDetailsService(securityService);
		
		// 접근에러시 이동 페이지
		http.exceptionHandling()
			.accessDeniedPage("/accessError");
		
		// 로그아웃 기능
		http.logout()
		    .logoutUrl("/logout")
		    .invalidateHttpSession(true);
		
		// 로그인 기능
		http.formLogin()
			.loginPage("/login")
			.failureHandler(authenticationFailureHandler())
			.successHandler(authenticationSuccessHandler())
			.and()
			.oauth2Login()
			.loginPage("/login")
			.userInfoEndpoint()
			.userService(customerOAuth2UserService);
	}
}
