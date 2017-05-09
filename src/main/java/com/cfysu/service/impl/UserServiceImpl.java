package com.cfysu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cfysu.service.UserService;
import com.cfysu.sqlmap.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	public int getUserCount() {
		
		return userMapper.countUser();
	}

}
