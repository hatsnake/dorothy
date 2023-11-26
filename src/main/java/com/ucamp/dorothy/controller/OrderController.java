package com.ucamp.dorothy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OrderController {
	@GetMapping("/orderHist")
	public String orderHistForm() {
		log.info("OrderHist Page Start");
		
		log.info("OrderHist Page End");
		
		return "order/orderHistForm";
	}
	
    @GetMapping("/order")
    public String showOrderPage(@RequestParam String itemName, @RequestParam Integer itemPrice, Model model) {

        model.addAttribute("itemName", itemName);
        model.addAttribute("itemPrice", itemPrice);
        
        return "order/orderForm";
    }
	

}