package com.cfysu.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by cj on 2017/9/1.
 */
@Component("topicProducer")
public class TopicProducer {

    @Autowired
    private JmsTemplate providerJmsTemplate;

    public void sendMqMessage(Destination destination, final String message){
        if(null == destination){
            destination = providerJmsTemplate.getDefaultDestination();
        }
        providerJmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
        System.out.println("spring send text message...");
    }
}
