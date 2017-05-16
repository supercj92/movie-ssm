package com.cfysu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cfysu.dao.UserDao;
import com.cfysu.model.User;
import com.cfysu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public int getUserCount() {
		return userDao.countUser();
	}

	public int insertUser(User user) {
		userDao.insert(user);
		return 0;
	}

}
