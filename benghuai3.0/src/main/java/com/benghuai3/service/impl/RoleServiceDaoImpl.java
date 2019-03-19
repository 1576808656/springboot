package com.benghuai3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benghuai3.bean.RoleInfo;
import com.benghuai3.bean.RoleMessage;
import com.benghuai3.mapper.RoleInfoMapper;
import com.benghuai3.service.RoleServiceDao;

@Service
public class RoleServiceDaoImpl implements RoleServiceDao {

	@Autowired
	private RoleInfoMapper mapper;
	@Override
	public RoleInfo selectRoleInfo(Integer id) {
		
		return mapper.selectRoleById(id);
	}
	@Override
	public RoleMessage selectRoleMessage(RoleInfo roleinfo) {
		// TODO Auto-generated method stub
		return mapper.selectRoleMessage(roleinfo);
	}
	@Override
	public RoleInfo changePrevRoleInfo(Integer id) {
		if(id != 1)
			id -= 1;
		else
			id = mapper.selectCount();
		return mapper.selectRoleById(id);
	}
	@Override
	public RoleInfo changeNextRoleInfo(Integer id) {
		if(id != mapper.selectCount())
			id += 1;
		else
			id = 1;
		return mapper.selectRoleById(id);
	}

}
