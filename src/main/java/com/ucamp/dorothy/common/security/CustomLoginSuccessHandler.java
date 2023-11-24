package com.ucamp.dorothy.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.ucamp.dorothy.common.mail.SendMail;
import com.ucamp.dorothy.common.sms.SendSms;
import com.ucamp.dorothy.domain.Member;
import com.ucamp.dorothy.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomLoginSuccessHandler extends 
SavedRequestAwareAuthenticationSuccessHandler{
	@Autowired
	private HttpSession httpSession;
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws ServletException, IOException {
		log.info("onAuthenticationSuccess");
		
		
		User customUser = (User) auth.getPrincipal();
		
		log.info("username = " + customUser.getUsername());
		
		try {
			Member member = memberMapper.findByEmail(customUser.getUsername());
			
			if(member != null) {
				httpSession.setAttribute("id", member.getId());
				httpSession.setAttribute("email", member.getEmail());
				httpSession.setAttribute("name", member.getName());
			}
		} catch(Exception e) {
			log.error(e.getMessage());
		}
		
		super.onAuthenticationSuccess(request, response, auth);
	}

}
