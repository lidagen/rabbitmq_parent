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
    /*****************************************TOPIC*******************************************************/
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
    /*****************************************TOPIC*******************************************************/

    /*****************************************Fanout广播*************************************************************/
    @Bean("fanoutExchange")
    public FanoutExchange FanoutExchange(){
        return ExchangeBuilder.fanoutExchange(ExchangeEnum.FANOUT.getName()).durable(true).build();
    }
    @Bean("oneQueue")
    public Queue fanoutQueueOne() {
        return QueueBuilder.durable(QueueEnum.FANOUT_QUEUE_ONE).build();
    }
    @Bean("twoQueue")
    public Queue fanoutQueueTwo() {
        return QueueBuilder.durable(QueueEnum.FANOUT_QUEUE_TWO).build();
    }


    @Bean
    public Binding fanoutOneQueueExchange(@Qualifier("oneQueue") Queue queue, @Qualifier("fanoutExchange") FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding fanoutTwoQueueExchange(@Qualifier("twoQueue") Queue queue, @Qualifier("fanoutExchange") FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }
    /*****************************************Fanout广播*************************************************************/
}
