package com.ucamp.dorothy.domain;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class SessionMember implements Serializable {
	private String name, email, picture;
	
	public SessionMember(Member member) {
		this.name = member.getName();
		this.email = member.getEmail();
	}
}
