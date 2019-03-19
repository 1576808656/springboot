package com.benghuai3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.benghuai3.bean.RoleHeadPic;
import com.benghuai3.service.RoleHeadDao;

@Controller
public class IndexController {

	@Autowired
	private RoleHeadDao role;
	@RequestMapping("index.html")
	public String index(Map<String,Object>map) {
		List<RoleHeadPic> roles = role.selectRoleHead();
		map.put("roles", roles);
		return "index";
	}
}
