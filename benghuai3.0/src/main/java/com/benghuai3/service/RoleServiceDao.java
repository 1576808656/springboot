package com.benghuai3.service;

import com.benghuai3.bean.RoleInfo;
import com.benghuai3.bean.RoleMessage;

public interface RoleServiceDao {
	//查找指定id的女武神
	public RoleInfo selectRoleInfo(Integer id);
	
	//查找对应女武神的信息
	public RoleMessage selectRoleMessage(RoleInfo roleinfo);
	
	//查找上一个女武神
	public RoleInfo changePrevRoleInfo(Integer id);
	
	//查找下一个女武神
	public RoleInfo changeNextRoleInfo(Integer id);
}
