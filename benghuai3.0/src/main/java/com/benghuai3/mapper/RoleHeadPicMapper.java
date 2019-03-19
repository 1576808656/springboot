package com.benghuai3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.benghuai3.bean.RoleHeadPic;

@Mapper
public interface RoleHeadPicMapper {

	@Select("select * from roleheadpic")
	public List<RoleHeadPic>selectRoleHead();
}
