package com.cfysu.action;

import com.alibaba.fastjson.JSON;
import com.cfysu.model.User;
import com.cfysu.service.UserService;
import com.cfysu.util.AjaxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by cj on 17-6-11.
 */
public class TestDBAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestDBAction.class);

    @Resource
    private UserService userService;

    public void testGetAllUser(){
        String jsonStr = JSON.toJSONString(userService.selectAllUser());
        LOGGER.info(jsonStr);
        AjaxUtil.send(jsonStr);
    }

    public void testCount(){
        Integer count = userService.getUserCount();
        LOGGER.info("count:{}",count);
        AjaxUtil.send(count.toString());
    }

    public void testInserUser(){
        User user = new User("rose", "rose_pwd");
        userService.insertUser(user);
    }
}
