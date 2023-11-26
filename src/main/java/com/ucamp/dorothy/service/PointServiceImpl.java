package com.ucamp.dorothy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucamp.dorothy.domain.Point;
import com.ucamp.dorothy.mapper.PointMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PointServiceImpl implements PointService {
	
	@Autowired
	private PointMapper pointMapper;

	@Override
	public List<Point> selectPointList() throws Exception {

		return pointMapper.selectPointList();
	}


}
