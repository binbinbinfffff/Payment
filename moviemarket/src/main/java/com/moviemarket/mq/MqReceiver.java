package com.moviemarket.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author:NewHongjay
 * @data:2018/4/18 20:08
 * mq消息的接收与处理
 */
public class MqReceiver implements MessageListener{

    public void onMessage(Message message) {
        try {
            System.out.println("收到消息----"+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

        TextMessage tm = (TextMessage) message;

    }
}
