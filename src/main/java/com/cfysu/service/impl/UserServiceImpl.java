package com.cfysu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.cfysu.dao.UsersDao;
import com.cfysu.model.User;
import com.cfysu.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UsersDao userDaoIbatisImpl;
	@Resource
	private UsersDao userDaoMybatisImpl;

	public int getUserCount() {
		return userDaoIbatisImpl.countUser();
	}

	public int insertUser(User user) {
		//userDao.insert(user);
		return 0;
	}

	public List<User> selectAllUser() {
		return userDaoMybatisImpl.selectAllUser();
	}
}
