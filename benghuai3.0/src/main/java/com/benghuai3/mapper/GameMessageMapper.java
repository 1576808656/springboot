package com.benghuai3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.benghuai3.bean.GameMessage;

@Mapper
public interface GameMessageMapper {
	//查询第i条到第j条的游戏信息
	@Select("select * from gamemessage where id>=#{i} and id<=#{j}")
	public List<GameMessage>selectAllMessage(int i,int j);
	
	//查询游戏信息总共有多少条
	@Select("select count(*) from gamemessage")
	public int selectMessageNum();
}
