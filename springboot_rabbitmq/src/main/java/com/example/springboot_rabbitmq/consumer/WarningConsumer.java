package com.example.springboot_rabbitmq.consumer;

import com.example.springboot_rabbitmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 31925
 */
@Slf4j
@Component
public class WarningConsumer {

    @RabbitListener(queues = ConfirmConfig.WARNING_QUEUE_NAME)
    public void receiveWarningMsg(Message message){
        String msg=new String(message.getBody());
        log.error("报警发现不可路由消息:{}",msg);
    }
}