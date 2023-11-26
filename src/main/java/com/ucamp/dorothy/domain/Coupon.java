package com.ucamp.dorothy.domain;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Coupon {
	private Integer id;
	private String name;
	private Integer price;
	private String useYn;
	private String activeYn;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime endDate;
	
	private String createdUser;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime createdDate;
	
	private String updatedUser;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime updatedDate;
	
	private Integer memberId;

}
