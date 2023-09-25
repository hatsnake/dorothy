package com.ucamp.dorothy.mapper;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.ucamp.dorothy.domain.Member;

public interface MemberMapper {
	public List<Member> list() throws Exception;
	public int register(Member member) throws Exception;
	public Member signIn(String email) throws Exception;
}
