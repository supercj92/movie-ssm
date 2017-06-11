package com.cfysu.action;

import com.alibaba.fastjson.JSON;
import com.cfysu.model.User;
import com.cfysu.service.UserService;

import javax.annotation.Resource;

/**
 * Created by cj on 17-6-11.
 */
public class TestDBAction {

    @Resource
    private UserService userService;

    public void testGetAllUser(){
        //System.out.println("count:" + userService.getUserCount());
        System.out.println("users:" + JSON.toJSONString(userService.selectAllUser()));
    }

    public void testCount(){
        System.out.println("count:" + userService.getUserCount());
    }

    public void testInserUser(){
        User user = new User("rose", "rose_pwd");
        userService.insertUser(user);
    }
}
