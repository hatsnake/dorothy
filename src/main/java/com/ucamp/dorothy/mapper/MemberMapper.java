package com.ucamp.dorothy.mapper;

import java.util.List;

import com.ucamp.dorothy.domain.Member;

public interface MemberMapper {
	public List<Member> list() throws Exception;
}
