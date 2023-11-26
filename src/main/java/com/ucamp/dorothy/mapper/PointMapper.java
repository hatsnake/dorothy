package com.ucamp.dorothy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ucamp.dorothy.domain.Point;

@Mapper
public interface PointMapper {
	public List<Point> selectPointList() throws Exception;

}
