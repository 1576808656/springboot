package com.benghuai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GushiController {

	@RequestMapping("gushi.html")
	public String gushi() {
		
		return "gushi";
	}
}
