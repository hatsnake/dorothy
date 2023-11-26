package com.ucamp.dorothy.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Order {
	
	private Integer id;
	private String status;
	private String comment;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime createdDate;
	
	private String updatedUser;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime updatedDate;
	
	private Integer memberId;	

}
