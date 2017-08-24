package com.chenxi.springboot.controller;

import com.chenxi.springboot.rabbitmq.RabbitMqConfig;
import com.chenxi.springboot.rabbitmq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenxi on 2017/8/23.
 *
 * @author chenxi
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqController {
    private Sender sender;

    @Autowired
    public void setSender(Sender sender) {
        this.sender = sender;
    }

    /**
     * 向消息队列1中发送消息
     *
     * @param msg
     * @return
     */
    @RequestMapping("/send1")
    public String send1(String msg) {
        sender.send(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY1, msg);
        return "success";
    }

    /**
     * 向消息队列2中发送消息
     *
     * @param msg
     * @return
     */
    @RequestMapping("/send2")
    public String send2(String msg) {
        sender.send(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY2, msg);
        return "success";
    }
}
