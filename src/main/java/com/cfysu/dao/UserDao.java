package com.cfysu.dao;

import com.cfysu.model.User;


public interface UserDao {
	public User selectUserByUserName(String userName);
}
