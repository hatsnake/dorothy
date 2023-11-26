package com.ucamp.dorothy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucamp.dorothy.domain.Payment;
import com.ucamp.dorothy.mapper.PaymentMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {
	
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public void insertPayment(Payment payment) {
        paymentMapper.insertPayment(payment);
    }
    
}
