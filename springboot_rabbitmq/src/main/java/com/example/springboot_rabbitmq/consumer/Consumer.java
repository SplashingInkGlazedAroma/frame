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
public class Consumer {

    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE_NAME)
    public void receiveConfirmMessage(Message message){

        String msg = new String(message.getBody());
        log.info("接受到队列confirm.queue消息:{}",msg);
    }
}