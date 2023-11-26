package com.ucamp.dorothy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucamp.dorothy.domain.Item;
import com.ucamp.dorothy.mapper.ItemMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<Item> selectItemList() throws Exception {

		return itemMapper.selectItemList();
		
	}

	public int calculateTotalAmount(List<Item> items) {
		
        int totalAmount = 0;
        
        for (Item item : items) {
            totalAmount += item.getPrice();
        }
        return totalAmount;
	}


}
