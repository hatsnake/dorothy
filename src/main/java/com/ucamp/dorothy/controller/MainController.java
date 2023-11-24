package com.ucamp.dorothy.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	@Autowired
	private HttpSession httpSession;
	
	@GetMapping("/")
	public String main() {
		
	    log.info("멤버 아이디 : " + httpSession.getAttribute("id") + ", 이메일 : " + httpSession.getAttribute("email"));
		log.info("Main Page Start");
		log.info("TEST");
		log.info("Main Page End");
		return "main";
	}
	
}
