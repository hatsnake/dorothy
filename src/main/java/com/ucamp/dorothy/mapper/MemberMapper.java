package com.ucamp.dorothy.mapper;

import java.util.List;
import java.util.Optional;

import com.ucamp.dorothy.domain.Member;
import com.ucamp.dorothy.domain.SendEmailHistory;

public interface MemberMapper {
	public List<Member> list() throws Exception;
	public int register(Member member) throws Exception;
	public Optional<Member> signIn(String email);
	public int emailDupCheck(String email) throws Exception;
	public void saveSendEmailHistory(SendEmailHistory emailInfo) throws Exception;
}
