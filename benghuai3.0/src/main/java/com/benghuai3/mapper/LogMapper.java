package com.benghuai3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.benghuai3.bean.Log;

@Mapper
public interface LogMapper {

	@Select("select * from log where userid=#{userid} order by date desc")
	public List<Log>selectByUserid(int id);

	@Insert("insert into `log` (`date`,`place`,`ip`,`action`,`userid`) values(#{date},#{place},#{ip},#{action},#{userid})")
	public int addLog(String date,String place,String ip,String action,int userid);
}
