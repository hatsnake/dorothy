package com.ucamp.dorothy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OrderController {
	@GetMapping("/orderHist")
	public String orderHistForm() {
		log.info("OrderHist Page Start");
		
		log.info("OrderHist Page End");
		
		return "/order/orderHistForm";
	}
	
	@GetMapping("/order")
	public String orderForm() {
		log.info("Order Page Start");
		
		log.info("Order Page End");
		

		return "/order/orderForm";

		}
}
