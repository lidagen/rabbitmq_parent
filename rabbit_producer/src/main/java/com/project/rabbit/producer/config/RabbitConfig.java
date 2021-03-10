package com.project.rabbit.producer.config;

import com.project.rabbit.common.enums.ExchangeEnum;
import com.project.rabbit.common.enums.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wang.song
 * @date 2021-03-10 14:31
 * @Desc
 */
@Configuration
public class RabbitConfig {
    /**
     * 定义queue名字
     */
    public static final String QUEUE_NAME = "MY_TOPIC_QUEUE";

    /**
     * 声明交换机
     */
    @Bean("topicExchange")
    public Exchange topicExchange() {
        return ExchangeBuilder.topicExchange(ExchangeEnum.TOPIC.getName()).durable(true).build();
    }

    /**
     * 声明队列
     */
    @Bean("itemQueue")
    public Queue itemQueue() {
        return QueueBuilder.durable(QueueEnum.TOPIC_QUEUE).build();
    }

    /**
     * 绑定交换机和队列
     * 通配符模式
     */
    @Bean
    public Binding itemQueueExchange(@Qualifier("itemQueue") Queue queue, @Qualifier("topicExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("item.#").noargs();
    }
}
