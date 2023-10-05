package com.ucamp.dorothy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	@GetMapping("/")
	public String main() {
		log.info("Main Page Start");
		log.info("TEST");
		log.info("Main Page End");
		return "main";
	}
	
}
