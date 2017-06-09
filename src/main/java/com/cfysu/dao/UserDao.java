package com.cfysu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cfysu.model.User;
import com.cfysu.model.UserExample;


public interface UserDao {

    int countUser();
    
    int insert(User record);

    List<User> selectAllUser();
    
}
