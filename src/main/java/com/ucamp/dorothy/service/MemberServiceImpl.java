package com.ucamp.dorothy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucamp.dorothy.domain.Member;
import com.ucamp.dorothy.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	private final MemberMapper mapper;

	@Override
	public List<Member> list() throws Exception {
		return mapper.list();
	}
	
}
