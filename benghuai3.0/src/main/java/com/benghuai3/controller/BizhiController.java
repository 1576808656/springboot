package com.benghuai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BizhiController {

	@RequestMapping("bizhi.html")
	public String bizhi() {
		
		return "bizhi";
	}
}
