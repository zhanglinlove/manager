package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.pojo.UserBean;

@Service
public class UserService {

	@Value("${name}")
	private String name;
	@Autowired
	private UserDao userDao;

	public int insertUser(UserBean userBean){
		return userDao.insertUser(userBean);
	}
	
	public UserBean adminLogin(UserBean userBean){
		UserBean user = userDao.selectUser(userBean);
		return user;
	}
	
	public String test() {
		return name;
	}
}
