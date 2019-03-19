package com.benghuai3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.benghuai3.bean.RoleInfo;
import com.benghuai3.bean.RoleMenu;
import com.benghuai3.bean.RoleMessage;
import com.benghuai3.mapper.RoleMenuMapper;
import com.benghuai3.service.RoleServiceDao;

@Controller
//@RequestMapping("role")
public class RoleController {

	@Autowired
	RoleMenuMapper role;
	@Autowired
	RoleServiceDao roleService;
	
	@GetMapping("/juese.html")
	public String getRoleMenu(Map<String,List<RoleMenu>>map) {
		System.out.println("启动方法");
		map.put("roleMenuList", role.selectAll());
		return "juese";
	}
	
	@RequestMapping("/{id}")
	public String getRoleInfo(@PathVariable("id") Integer id,Map<String,Object>map) {
		System.out.println("查看一个女武神");
		RoleInfo roleinfo = roleService.selectRoleInfo(id);
		map.put("roleinfo", roleinfo);
		RoleMessage rolemessage = roleService.selectRoleMessage(roleinfo);
		map.put("rolemessage", rolemessage);

		return "roleDetail";
	}
	
	@RequestMapping("/prev{id}")
	public String changePrev(@PathVariable("id")Integer id,Map<String,Object>map) {
		
		RoleInfo roleinfo = roleService.changePrevRoleInfo(id);
		RoleMessage rolemessage = roleService.selectRoleMessage(roleinfo);
		map.put("roleinfo", roleinfo);
		map.put("rolemessage", rolemessage);
		return "roleDetail";
	}
	
	@RequestMapping("/next{id}")
	public String changeNext(@PathVariable("id")Integer id,Map<String,Object>map) {

		RoleInfo roleinfo = roleService.changeNextRoleInfo(id);
		RoleMessage rolemessage = roleService.selectRoleMessage(roleinfo);
		map.put("roleinfo", roleinfo);
		map.put("rolemessage", rolemessage);
		return "roleDetail";
	}
}
