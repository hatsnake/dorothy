package com.ucamp.dorothy.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ucamp.dorothy.domain.Order;

@Mapper
public interface OrderMapper {
    void insertOrder(Order order);
}