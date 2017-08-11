package com.cfysu.dao;

import java.util.List;

import com.cfysu.model.User;


public interface UsersDao {

    int countUser();
    
    int insert(User record);

    List<User> selectAllUser();
    
}
