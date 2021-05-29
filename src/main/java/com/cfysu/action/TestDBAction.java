package com.cfysu.action;

import com.alibaba.fastjson.JSON;
import com.cfysu.model.User;
import com.cfysu.mq.TopicProducer;
import com.cfysu.service.UserService;
import com.cfysu.util.AjaxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;

/**
 * Created by cj on 17-6-11.
 */
public class TestDBAction implements ApplicationContextAware{

    private static final Logger LOGGER = LoggerFactory.getLogger(TestDBAction.class);

    @Resource
    private UserService userService;

    @Resource
    private TopicProducer topicProducer;

    private ApplicationContext applicationContext;

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

    /**
     * 测试消息发送
     */
    public void testMQ(){
        System.out.println("-----test mq----");
        topicProducer.sendMqMessage(null, "a msg from ssm-project");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
