package com.dao.mapper;

import org.springframework.stereotype.Component;

import com.pojo.UserBean;

@Component
public interface UserMapper {

	public int insertUser(UserBean userBean);
	
	public UserBean selectUser(UserBean userBean);
}
