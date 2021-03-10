package com.project.rabbit.consumer.listener;

import com.project.rabbit.common.enums.QueueEnum;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wang.song
 * @date 2021-03-10 16:23
 * @Desc
 */
@Component
public class FanoutOneListener {
    @RabbitListener(queues = QueueEnum.FANOUT_QUEUE_ONE)
    public void msg(String msg) {

        System.out.println("FANOUT1收到消息：" + msg);
    }
}
