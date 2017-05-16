package com.cfysu.service;

import com.cfysu.model.User;

public interface UserService {
	
	int getUserCount();
	
	int insertUser(User user);
}
