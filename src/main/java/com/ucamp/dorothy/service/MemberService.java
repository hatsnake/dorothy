package com.ucamp.dorothy.service;

import java.util.List;

import com.ucamp.dorothy.domain.Member;

public interface MemberService {
	public List<Member> list() throws Exception;
	public int register(Member member) throws Exception;
}
