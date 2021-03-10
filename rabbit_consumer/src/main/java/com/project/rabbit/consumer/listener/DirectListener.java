package com.project.rabbit.consumer.listener;

import com.project.rabbit.common.enums.QueueEnum;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wang.song
 * @date 2021-03-10 16:44
 * @Desc
 */@Component
public class DirectListener {
    @RabbitListener(queues = QueueEnum.DIRECT_QUEUE)
    public void msg(String msg) {

        System.out.println("DIRECT收到消息：" + msg);
    }
}
