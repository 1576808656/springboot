package com.benghuai3.service;

import java.util.List;

import com.benghuai3.bean.GameMessage;

public interface GameMessageDao {

	//查找第i条到第j条游戏的相关信息
	public List<GameMessage>selectAllMessage(int i,int j);
	
	//查询游戏信息总共有多少条
	public int selectMessageNum();
}
