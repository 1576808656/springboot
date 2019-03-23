package com.benghuai3.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.benghuai3.bean.HeadPic;
import com.benghuai3.bean.User;
import com.benghuai3.service.UserServiceDao;

@Controller
public class UserController {

	@Autowired
	private UserServiceDao userService;
	
	@RequestMapping("userinfo")
	public String userinfo() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null)
			return "zhuce";
		session.setAttribute("log", userService.selectLog(user.getId()));
		return "user";
	}
	
	@RequestMapping("/exit")
	public String exit() {
		setSession("user",null);
		return "index";
	}
	
	@RequestMapping("/update")
	public String update(User user) throws UnknownHostException {
		//int id = user.getId();
		System.out.println(user.getId());
		User users = userService.selectById(user.getId());
		int n = userService.updateUser(user.getName(), user.getAccount(), user.getPassword(), user.getHeadPic(),user.getId());
		setSession("headPic",userService.selectAllHeadPic());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		String ip = InetAddress.getLocalHost()+"";
		ip = ip.substring(ip.indexOf("/")+1,ip.length());
		userService.addUserLog(date, "中国", ip, "修改信息", user);
		if(n != 0) {
			setSession("user", user);
			setSession("log",userService.selectLog(user.getId()));
		}else {
			setSession("log",userService.selectLog(users.getId()));
			setSession("user", users);
		}
		return "user";
	}
	
	@RequestMapping("/zhuce.html")
	public String zhuce() {

		return "zhuce";
	}
	
	@RequestMapping("/errors")
	public String error(Map<String,String>map) {
		map.put("errors", "两次密码不一致");
		return "zhuce";
	}
	
	@RequestMapping("/no")
	public String no(Map<String,String>map) {
		map.put("nonull", "请完整填写注册信息");
		return "zhuce";
	}
	
	@RequestMapping("/register")
	public String register(User user) {
		System.out.println(user.getHeadPic());
		int n = userService.register(user.getName(), user.getAccount(), user.getPassword(), user.getHeadPic());
		System.out.println(n);
		if(n == 0) {
			setSession("isUser", "用户账号已存在");
			setSession("user", null);
			return "zhuce";
		}else {
			setSession("isUser", null);
			int id = userService.selectByAccount(user.getAccount()).getId();
			user.setId(id);
			setSession("user", user);
		}
		setSession("headPic",userService.selectAllHeadPic());
		return "user"; 
	}
	
	
	@RequestMapping("/login{account}/{password}")
	public String login(@PathVariable("account")String account,@PathVariable("password")String password) throws UnknownHostException {
		User user = userService.login(account, password);
		System.out.println("用户名："+account+"---"+"密码："+password);
		if(user == null) {
			return "index";
		}

		setSession("user", user);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		String ip = InetAddress.getLocalHost()+"";
		ip = ip.substring(ip.indexOf("/")+1,ip.length());
		userService.addUserLog(date, "中国", ip, "登录", user);
		setSession("headPic",userService.selectAllHeadPic());
		setSession("log",userService.selectLog(user.getId()));
		return "user";
	}
	
	private void setSession(String key,Object obj) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
				.getRequestAttributes()).getRequest();

		HttpSession session = request.getSession();
		session.setAttribute(key, obj);
	}
}
