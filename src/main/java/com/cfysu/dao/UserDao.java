package com.cfysu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cfysu.model.User;
import com.cfysu.model.UserExample;


public interface UserDao {
	public User selectUserByUserName(String userName);
	
	int countByExample(UserExample example);
	
    int countUser();
    
    int deleteByExample(UserExample example);

    int insert(User record);
    
    int insertSelective(User record);
    
    List<User> selectByExample(UserExample example);
    
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
    
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    
}
