package com.project.rabbit.common.enums;

/**
 * @author wang.song
 * @date 2021-03-10 15:31
 * @Desc 交换机Enum
 */

public enum ExchangeEnum {
    TOPIC("MY_TOPIC_EXCHANGE","通配符规则Exchange"),
    DIRECT("MY_DIRECT_EXCHANGE","定向规则Exchange"),
    FANOUT("MY_FANOUT_EXCHANGE","广播规则Exchange");

    private String name;
    private String desc;

    ExchangeEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName(){
        return name;
    }
}
