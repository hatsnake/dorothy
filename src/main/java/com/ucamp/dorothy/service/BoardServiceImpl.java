package com.ucamp.dorothy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucamp.dorothy.domain.Board;
import com.ucamp.dorothy.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private final BoardMapper mapper;
	
	@Override
	public List<Board> list() throws Exception {
		return mapper.list();
	}
}
