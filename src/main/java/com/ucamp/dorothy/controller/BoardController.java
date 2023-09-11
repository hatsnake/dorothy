package com.ucamp.dorothy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucamp.dorothy.domain.Board;
import com.ucamp.dorothy.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {
	private final BoardService service;
	
	@GetMapping
	public ResponseEntity<List<Board>> list() throws Exception {
		log.info("list");
		
		return new ResponseEntity<>(service.list(), HttpStatus.OK);
	}
}
