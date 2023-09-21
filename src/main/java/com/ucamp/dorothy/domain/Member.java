package com.ucamp.dorothy.domain;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	private int id;
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
}
