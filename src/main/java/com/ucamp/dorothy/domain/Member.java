package com.ucamp.dorothy.domain;

import java.time.LocalDateTime;

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
	private LocalDateTime createdDate;
	private String updatedUser;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime updatedDate;
}
