package com.ucamp.dorothy.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RequestMapping("/members")
public class MemberController {
	
	@GetMapping("/login")
	public String loginForm(String error, String logout, Model model) {
		log.info("Login Page Start");
		log.info("error : " + error);
		log.info("logout : " + logout);
		
		if(error != null) {
			model.addAttribute("error", error);
		}
		
		if(logout != null) {
			model.addAttribute("logout", logout);
		}
		
		log.info("Login Page End");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth instanceof AnonymousAuthenticationToken)
			return "/members/loginForm";
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		log.info("Register Page Start");

		log.info("Register Page End");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth instanceof AnonymousAuthenticationToken)
			return "/members/registerForm";
		return "redirect:/";
	}
}
