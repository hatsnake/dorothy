package com.ucamp.dorothy.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	private Integer id;
	private String email;
	private String pw;
	private String name;
	private String hp;
	private String deleteYn;
	private String auth;
	private String createdUser;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime createdDate;
	private String updatedUser;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime updatedDate;
	
	public Member hashPassword(PasswordEncoder passwordEncoder) {
		this.pw = passwordEncoder.encode(this.pw);
		return this;
	}
	
	public boolean checkPassword(String plainPassword, PasswordEncoder passwordEncoder) {
		return passwordEncoder.matches(plainPassword, this.pw);
	}
	
	public Member(Integer id, String email, String pw, String name) {
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.name = name;
	}
}
