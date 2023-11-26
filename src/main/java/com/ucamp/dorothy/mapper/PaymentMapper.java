package com.ucamp.dorothy.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ucamp.dorothy.domain.Payment;

@Mapper
public interface PaymentMapper {
	void insertPayment(Payment payment);

}
