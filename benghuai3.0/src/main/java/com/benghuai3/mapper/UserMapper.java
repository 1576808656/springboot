package com.benghuai3.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.benghuai3.bean.User;

@Mapper
public interface UserMapper {
	
	@Update("update user set name=#{name},account=#{account},password=#{password},headPic=#{headPic} where id=#{id}")
	public int updateUser(String name,String account,String password,String headPic,int id);

	@Insert("insert into `user` (`name`,`account`,`password`,`headPic`) values (#{name},#{account},#{password},#{headPic})")
	@Options(useGeneratedKeys=true,keyProperty="user.id")
	public int register(String name,String account,String password,String headPic);
	
	@Select("select * from user where account=#{account}")
	public User selectUserByAccount(String account);
	
	@Select("select * from user where account=#{account} and password=#{password}")
	public User selectUser(String account,String password);
	
	@Select("select * from user where id=#{id}")
	public User selectUsers(int id);
	
	@Select("select * from user where id=#{id}")
	public User selectUserById(int id);
	
	@Select("select * from user where id=#{id}")
	@Results({
		//把查询到的user的id（column="id"）给log对象（property="log"）去LogMapper的selectByUserid查询log
		@Result(property="log",column="id",
				many=@Many(select="com.benghuai3.mapper.LogMapper.selectByUserid"))
	})
	public User getUser(int id);
	
	@Select("select * from user where id=#{id}")
	@Results({
		@Result(property="log",column="id",
				many=@Many(select="com.benghuai3.mapper.LogMapper.addLog"))
	})
	public int addUserLog(int id);
}
