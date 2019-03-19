package com.benghuai3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.benghuai3.bean.RoleMenu;

//指定这是一个操纵数据库的mapper
@Mapper
public interface RoleMenuMapper {

	@Select("select * from rolemenu")
	public List<RoleMenu>selectAll();
}
