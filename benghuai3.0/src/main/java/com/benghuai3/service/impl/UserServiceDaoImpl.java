package com.benghuai3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benghuai3.bean.HeadPic;
import com.benghuai3.bean.Log;
import com.benghuai3.bean.User;
import com.benghuai3.mapper.HeadPicMapper;
import com.benghuai3.mapper.LogMapper;
import com.benghuai3.mapper.UserMapper;
import com.benghuai3.service.UserServiceDao;

@Service
public class UserServiceDaoImpl implements UserServiceDao {

	@Autowired
	private UserMapper mapper;
	@Autowired
	private LogMapper logmapper;
	
	@Autowired
	private HeadPicMapper picmapper;
	
	@Override
	public int register(String name, String account, String password, String headPic) {
		User user = mapper.selectUserByAccount(account);
		if(user != null)
			return 0;
		int n = mapper.register(name, account, password, headPic);
		return n;
	}
	@Override
	public User login(String account, String password) {
		if(account == null || password == null)
			return null;
		System.out.println("用户名："+account+"---"+"用户密码："+password);
		User user = mapper.selectUser(account,password);
		return user;
	}
	@Override
	public User selectByAccount(String account) {
		User user = mapper.selectUserByAccount(account);
		return user;
	}
	@Override
	public int addUserLog(String date, String place, String ip, String action, User user) {

		return logmapper.addLog(date, place, ip, action, user.getId());
	}
	@Override
	public List<HeadPic> selectAllHeadPic() {
		// TODO Auto-generated method stub
		return picmapper.selectAllHeadPic();
	}
	@Override
	public int updateUser(String name, String account, String password, String headPic,int id) {
		if(name == null || account == null || password == null)
			return 0;
		if(name.length()<=0 || account.length()<=0 || password.length()<=0)
			return 0;
		return mapper.updateUser(name, account, password, headPic,id);
	}
	@Override
	public User selectById(int id) {
		// TODO Auto-generated method stub
		return mapper.selectUserById(id);
	}
	@Override
	public List<Log> selectLog(int id) {
		// TODO Auto-generated method stub
		return logmapper.selectByUserid(id);
	}

}
