package com.my.dev.controller;

import com.alibaba.fastjson.JSON;
import com.my.common.CopyUtils;
import com.my.dev.entity.userinfo.SysUserEntity;
import com.my.dev.service.ISysUserService;
import com.my.mqinfo.SysUserInfo;
import lombok.SneakyThrows;
import netscape.javascript.JSObject;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;
import java.io.Serializable;


/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月15日19:13:55$
 */
@RestController
@RequestMapping("/test/producer")
public class TestProducerController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    @Autowired
    private ISysUserService sysUserService;

    @PostMapping("/queue/test")
    public String sendQueue() {
        SysUserInfo user=new SysUserInfo();
        SysUserEntity entity=sysUserService.findUserInfo(4);
        CopyUtils.copyProperties(entity,user);
        this.sendMessage(this.queue,JSON.toJSONString(user));
        return "success";
    }

    @PostMapping("/topic/test")
    public String sendTopic() {
        SysUserInfo user=new SysUserInfo();
        SysUserEntity entity=sysUserService.findUserInfo(4);
        CopyUtils.copyProperties(entity,user);
        this.sendMessage(this.topic, JSON.toJSONString(user));
        return "success";
    }

    // 发送消息，destination是发送到的队列，message是待发送的消息
    @SneakyThrows
    private void sendMessage(Destination destination, String obj){
        jmsMessagingTemplate.convertAndSend(destination, obj);
    }
}
