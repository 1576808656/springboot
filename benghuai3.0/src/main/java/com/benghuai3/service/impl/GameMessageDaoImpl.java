package com.benghuai3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benghuai3.bean.GameMessage;
import com.benghuai3.mapper.GameMessageMapper;
import com.benghuai3.service.GameMessageDao;

@Service
public class GameMessageDaoImpl implements GameMessageDao {

	@Autowired
	private GameMessageMapper mapper;
	@Override
	public List<GameMessage> selectAllMessage(int i,int j) {
		// TODO Auto-generated method stub
		return mapper.selectAllMessage(i,j);
	}
	@Override
	public int selectMessageNum() {
		// TODO Auto-generated method stub
		return mapper.selectMessageNum();
	}

}
