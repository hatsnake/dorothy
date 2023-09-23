package com.ucamp.dorothy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OrderController {
	@GetMapping("/order")
	public String order() {
		log.info("Order Page Start");
		
		log.info("Order Page End");
		
		return "order/orderHist";
	}

}
