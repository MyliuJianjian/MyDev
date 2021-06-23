package com.my.dev.config;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月23日13:45:48$
 */
import com.alibaba.fastjson.JSONObject;
import com.my.mqinfo.SysUserInfo;
import lombok.SneakyThrows;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

@Component
public class QueueConsumerListener
{
    //queue模式的消费者
    @SneakyThrows
    @JmsListener(destination="${spring.activemq.queue-name}", containerFactory="queueListener")
    public void readActiveQueue(String message) {

        SysUserInfo str=JSONObject.parseObject(message,SysUserInfo.class);
        System.out.println("queue接受到："+message);
    }
}
