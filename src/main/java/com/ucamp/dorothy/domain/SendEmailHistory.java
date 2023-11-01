package com.ucamp.dorothy.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SendEmailHistory {
	private Integer id;
	private String emailAddress;
	private String subject;
	private String verifyCode;
	private String content;
	private String emailType;
	private String createdUser;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime createdDate;
	private String updatedUser;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime updatedDate;
}
