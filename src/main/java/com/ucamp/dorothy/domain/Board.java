package com.ucamp.dorothy.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {
	private long boardNo;
	private String title;
	private String content;
	private String writer;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime regDate;
}
