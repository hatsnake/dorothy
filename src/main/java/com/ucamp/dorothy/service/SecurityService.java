package com.ucamp.dorothy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ucamp.dorothy.domain.Member;
import com.ucamp.dorothy.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SecurityService implements UserDetailsService {
	private final MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = null;
		List<GrantedAuthority> authorities = null;
		try {
			member = mapper.signIn(email);
	        authorities = new ArrayList<>();
	        authorities.add(new SimpleGrantedAuthority("MEMBER"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new User(member.getEmail(), member.getPw(), authorities);
	}
}
