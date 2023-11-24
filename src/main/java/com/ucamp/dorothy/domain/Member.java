package com.ucamp.dorothy.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
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
	
	@Builder
	public Member(String name, String email, String auth) {
		this.name = name;
		this.email = email;
		this.auth = auth;
	}
	
	public Member(Integer id, String email, String pw, String name) {
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.name = name;
	}

	public Member(Integer id, String email, String pw, String name, String hp, String deleteYn, String auth,
			String createdUser, LocalDateTime createdDate, String updatedUser, LocalDateTime updatedDate) {
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.hp = hp;
		this.deleteYn = deleteYn;
		this.auth = auth;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}
}
