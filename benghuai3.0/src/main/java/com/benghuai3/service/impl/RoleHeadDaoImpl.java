package com.benghuai3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benghuai3.bean.RoleHeadPic;
import com.benghuai3.mapper.RoleHeadPicMapper;
import com.benghuai3.service.RoleHeadDao;

@Service
public class RoleHeadDaoImpl implements RoleHeadDao {

	@Autowired
	private RoleHeadPicMapper mapper;
	@Override
	public List<RoleHeadPic> selectRoleHead() {
		// TODO Auto-generated method stub
		return mapper.selectRoleHead();
	}

}
