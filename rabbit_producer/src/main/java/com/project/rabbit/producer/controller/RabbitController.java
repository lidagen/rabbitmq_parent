package com.project.rabbit.producer.controller;

import com.project.rabbit.common.enums.ExchangeEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wang.song
 * @date 2021-03-10 14:28
 * @Desc
 */
@RestController
public class RabbitController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg")
    public String sendMsg(@RequestParam String msg, @RequestParam String key) {
        /**
         * exchange 交换机名称
         * routingKey 路由key
         * object消息
         */
        rabbitTemplate.convertAndSend(ExchangeEnum.TOPIC.getName(),key,msg);
        return "发送消息成功！";
    }


    @GetMapping("/fanoutSendMsg")
    public String fanoutSendMsg(@RequestParam String msg) {
        /**
         * exchange 交换机名称
         * routingKey 路由key
         * object消息
         */
        rabbitTemplate.convertAndSend(ExchangeEnum.FANOUT.getName(),"",msg);
        return "发送消息成功！";
    }
}
