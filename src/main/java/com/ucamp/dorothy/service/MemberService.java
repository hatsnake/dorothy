package com.ucamp.dorothy.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ucamp.dorothy.domain.SendEmailHistory;
import com.ucamp.dorothy.domain.Member;

public interface MemberService {
	public List<Member> list() throws Exception;
	public int register(Member member) throws Exception;
	public int emailDupCheck(String email) throws Exception;
	public String sendVerifyEmail(String email) throws Exception;
	public String sendVerifySms(String hp) throws Exception;
	public int checkAccountByResetPw(Member member) throws Exception;
	public int updateResetPw(Member member) throws Exception;
}
