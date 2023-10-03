package com.ucamp.dorothy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucamp.dorothy.domain.Member;
import com.ucamp.dorothy.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberRestController {
	private final MemberService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(Member member) throws Exception {
		log.info("Member Register Start");
		
		log.info("Member Register End");
		
		return service.register(member) >= 1 ? new ResponseEntity<>((new String("success")), HttpStatus.OK)
											 : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/register/emailDupCheck")
	public ResponseEntity<Boolean> emailDupCheck(String email) throws Exception {
		log.info("Email Duplicate Check Start");
		
		boolean dupFlag = service.emailDupCheck(email) == 0 ? true : false;
		
		log.info("Email Duplicate Check End");
		
		return new ResponseEntity<>(dupFlag, HttpStatus.OK);
	}
}
