package com.ucamp.dorothy.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Item {
	
	private Integer id;
	private String name;
	private String description;
	private String imageMain;
	private Integer price;
	private Integer discount;
	private String recommYn;
	private String activeYn;

	private String createdUser;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime createdDate;
	
	private String updatedUser;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime updatedDate;
	
	private Integer itemCategoryId;
	
	private Integer salePrice;
	

	

}
