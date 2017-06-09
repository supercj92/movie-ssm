package com.cfysu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cfysu.dao.UserDao;
import com.cfysu.model.User;
import com.cfysu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	@Resource
	private UserDao userDaoIbatisImpl;

	public int getUserCount() {
		return userDaoIbatisImpl.countUser();
	}

	public int insertUser(User user) {
		userDao.insert(user);
		return 0;
	}

	public List<User> selectAllUser() {
		return userDao.selectAllUser();
	}
}
