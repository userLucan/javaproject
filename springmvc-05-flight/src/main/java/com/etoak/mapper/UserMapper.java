package com.etoak.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.etoak.bean.User;

public interface UserMapper {

	@Select("select id,name,password,role from t_springmvc_user where name = #{name} and password = #{password}")
	User queryUser(@Param("name")String name,@Param("password")String password);
}
