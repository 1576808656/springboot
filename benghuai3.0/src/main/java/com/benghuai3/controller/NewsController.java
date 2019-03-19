package com.benghuai3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.benghuai3.bean.GameMessage;
import com.benghuai3.service.GameMessageDao;

@Controller
public class NewsController {

	@Autowired
	private GameMessageDao gamemessage;
	@RequestMapping("/zixun.html{i}")
	public String getAllMessage(Map<String,Object>map,@PathVariable("i")Integer i) {
		int j = i+9;
		i = i+5;
		if(j > gamemessage.selectMessageNum()) {
			j = gamemessage.selectMessageNum();
		}
		List<GameMessage> message = gamemessage.selectAllMessage(i,j);
		map.put("message", message);
		map.put("i", i);
		map.put("j", j);
		return "zixun";
	}
	
	@RequestMapping("/zixun.html")
	public String getAllMessage(Map<String,Object>map) {
		List<GameMessage> message = gamemessage.selectAllMessage(1,5);
		map.put("message", message);
		map.put("i", 1);
		map.put("j", 5);
		return "zixun";
	}
}
