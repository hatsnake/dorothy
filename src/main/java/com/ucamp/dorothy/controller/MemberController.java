package com.ucamp.dorothy.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	@GetMapping("/login")
	public String loginForm(@RequestParam(required = false) String error, 
							@RequestParam(required = false) String exception, 
							Model model) {
		log.info("Login Page Start");
		log.info("error : " + error);
		log.info("exception : " + exception);
		
		if(error != null) {
			model.addAttribute("exception", exception);
		}
		
		log.info("Login Page End");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth instanceof AnonymousAuthenticationToken)
			return "member/loginForm";
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		log.info("Register Page Start");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth instanceof AnonymousAuthenticationToken)
			return "member/registerForm";
		return "redirect:/";
	}
	
	@GetMapping("/resetPassword")
	public String resetPasswordForm() {
		log.info("Reset Password Page Start");
				
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth instanceof AnonymousAuthenticationToken)
			return "member/resetPasswordForm";
		return "redirect:/";
	}
}
