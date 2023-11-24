package com.ucamp.dorothy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucamp.dorothy.common.mail.SendMail;
import com.ucamp.dorothy.config.SecurityConfig;
import com.ucamp.dorothy.domain.Member;
import com.ucamp.dorothy.domain.SendEmailHistory;
import com.ucamp.dorothy.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberRestController {
	private final MemberService service;
	private final SendMail sendMail;
	private final PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(Member member) throws Exception {
		log.info("Member Register Start");
		
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
	
	@PostMapping("/email/emailVerify")
	public String emailVerify(SendEmailHistory sendEmailHistory) throws Exception {
		log.info("emailVerify() start");
		
		return service.sendVerifyEmail(sendEmailHistory.getEmailAddress());
	}
	
	@PostMapping("/sms/smsVerify")
	public String smsVerify(String hp) throws Exception {
		log.info("smsVerify() start");
		
		return service.sendVerifySms(hp);
	}
	
	@GetMapping("/email/checkAccountByResetPw")
	public ResponseEntity<Boolean> checkAccountByResetPw(Member member) throws Exception {
		log.info("checkAccountByResetPw() Start");
		int result = service.checkAccountByResetPw(member);
		boolean resultFlag = false;
		if(result == 1) {
			resultFlag = true;
		}
		
		return new ResponseEntity<>(resultFlag, HttpStatus.OK);
	}
	
	@PostMapping("/email/resetPw")
	public ResponseEntity<Boolean> resetPw(Member member) throws Exception {
		log.info("resetPw() start");
		String randomPw = sendMail.generateRandomCode(8);
		SendEmailHistory emailInfo = sendMail.sendResetPwMail(member.getEmail(), randomPw);
		boolean updateFlag = false;
		
		if(emailInfo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Member updateMember = new Member();
		updateMember.setEmail(member.getEmail());
		updateMember.setName(member.getName());
		updateMember.setPw(passwordEncoder.encode(randomPw));
		System.out.println("업데이트 멤버 정보 : " + updateMember.toString());
		
		int updateResult = service.updateResetPw(updateMember);
		
		if(updateResult == 1) {
			updateFlag = true;
		}
		
		return new ResponseEntity<>(updateFlag, HttpStatus.OK);
	}
	
}
