package com.ucamp.dorothy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ucamp.dorothy.domain.Member;
import com.ucamp.dorothy.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	private final MemberMapper mapper;
	private final PasswordEncoder bcryptPasswordEncoder;

	@Override
	public List<Member> list() throws Exception {
		return mapper.list();
	}

	@Override
	public int register(Member member) throws Exception {
		member.hashPassword(bcryptPasswordEncoder);
		return mapper.register(member);
	}

	@Override
	public int emailDupCheck(String email) throws Exception {
		return mapper.emailDupCheck(email);
	}
}
