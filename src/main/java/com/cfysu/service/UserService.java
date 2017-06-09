package com.cfysu.service;

import java.util.List;

import com.cfysu.model.User;

public interface UserService {
	
	int getUserCount();
	
	int insertUser(User user);
	
	List<User> selectAllUser();
}
