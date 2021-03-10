package com.project.rabbit.consumer.listener;

import com.project.rabbit.common.enums.QueueEnum;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wang.song
 * @date 2021-03-10 15:25
 * @Desc
 */
@Component
public class TopicListener {
    @RabbitListener(queues = QueueEnum.TOPIC_QUEUE)
    public void msg(String msg) {

        System.out.println("收到消息：" + msg);
    }
}
