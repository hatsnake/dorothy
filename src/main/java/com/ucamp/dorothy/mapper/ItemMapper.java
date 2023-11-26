package com.ucamp.dorothy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ucamp.dorothy.domain.Item;

@Mapper
public interface ItemMapper {
	public List<Item> selectItemList() throws Exception;

}
