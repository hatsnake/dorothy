package com.ucamp.dorothy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucamp.dorothy.domain.Item;
import com.ucamp.dorothy.service.ItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/myPage")
public class myPageController {
	
	@GetMapping
	public String myPage(Model model) throws Exception {

		return "myPage/myPageForm";
	}


}
