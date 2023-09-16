package com.ucamp.dorothy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
public class MemberController {
	private final MemberService service;
	
	@GetMapping
	public ResponseEntity<List<Member>> list() throws Exception {
		log.info("Member List");
		
		return new ResponseEntity<>(service.list(), HttpStatus.OK);
	}
}
