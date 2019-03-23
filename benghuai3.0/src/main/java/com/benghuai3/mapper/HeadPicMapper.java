package com.benghuai3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.benghuai3.bean.HeadPic;

@Mapper
public interface HeadPicMapper {

	@Select("select * from headPic")
	public List<HeadPic>selectAllHeadPic();
}
