package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.mapper.UserMapper;
import com.pojo.UserBean;

@Repository
public class UserDao {

	@Autowired
	private UserMapper userMapper;

	public int insertUser(UserBean userBean){
		return userMapper.insertUser(userBean);
	}
	
	public UserBean selectUser(UserBean userBean){
		return userMapper.selectUser(userBean);
	}
}
