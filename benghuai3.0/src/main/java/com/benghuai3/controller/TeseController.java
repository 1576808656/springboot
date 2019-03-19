package com.benghuai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeseController {

	@RequestMapping("tese.html")
	public String tese() {
		
		return "tese";
	}
}
