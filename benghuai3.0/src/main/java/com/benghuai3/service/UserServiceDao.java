package com.benghuai3.service;

import java.util.List;

import com.benghuai3.bean.HeadPic;
import com.benghuai3.bean.Log;
import com.benghuai3.bean.User;

public interface UserServiceDao {

	//用户注册
	public int register(String name,String account,String password,String headPic);
	
	//用户登录
	public User login(String account,String password);
	
	//通过账号查找用户
	public User selectByAccount(String account);
	
	//通过id查找用户
	public User selectById(int id);
	
	//通过用户id查找日志
	public List<Log>selectLog(int id);
	
	//添加用户日志
	public int addUserLog(String date,String place,String ip,String action,User userid);
	
	//查找所有头像
	public List<HeadPic>selectAllHeadPic();
	
	//更新用户信息
	public int updateUser(String name,String account,String password,String headPic,int id);
}
