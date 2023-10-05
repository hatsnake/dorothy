package com.ucamp.dorothy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PaymentController {
	@GetMapping("/coupon")
	public String couponForm() {
		log.info("Coupon Page Start");
		
		log.info("Coupon Page End");
		
		return "/payment/couponForm";
	}
	
	@GetMapping("/payment")
	public String paymentForm() {
		log.info("Payment Page Start");
		
		log.info("Payment Page End");
		
		return "/payment/paymentForm";
	}
}
