package com.ucamp.dorothy.service;

import java.util.List;

import com.ucamp.dorothy.domain.Item;

public interface ItemService {

	List<Item> selectItemList() throws Exception;

	int calculateTotalAmount(List<Item> items);

}
