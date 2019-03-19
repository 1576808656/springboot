package com.benghuai3.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.benghuai3.bean.RoleInfo;
import com.benghuai3.bean.RoleMessage;

@Mapper
public interface RoleInfoMapper {

	@Select("select * from roleinfo where id=#{id}")
	public RoleInfo selectRoleById(Integer id);
	
	@Select("select * from rolemessage where roleid=#{roleinfo.id}")
	public RoleMessage selectRoleMessage(@Param(value="roleinfo")RoleInfo roleinfo);
	
	@Select("select count(*) from roleinfo")
	public int selectCount();
}
