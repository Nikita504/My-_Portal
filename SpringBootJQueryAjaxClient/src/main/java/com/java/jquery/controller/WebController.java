package com.java.jquery.controller;

import javax.servlet.http.HttpSession; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping(value = "/")
	public String homepage() {
		return "index";
	}

	@GetMapping(value = "/ShowNextPage")
	public String ShowDatas(HttpSession httpsession) {
		return "ShowData";
	}
} 	 