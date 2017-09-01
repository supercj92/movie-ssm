package com.cfysu;

import com.cfysu.mq.TopicProducer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by cj on 2017/9/1.
 */
public class ContextTest {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:context/ApplicationContext.xml"});
        TopicProducer topicProducer = (TopicProducer)context.getBean("topicProducer");
        topicProducer.sendMqMessage(null, "a msg from ssm-project");
        System.out.println("----");
    }
}
