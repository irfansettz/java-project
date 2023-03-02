package com.ikon.rabbitmqserviceconsumer.controller;

import com.ikon.rabbitmqserviceconsumer.config.RabbitMqConsumerConfig;
import com.ikon.rabbitmqserviceconsumer.dto.RabbitMqConsumerDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class RabbitConsumerController {
    @RabbitListener(queues = RabbitMqConsumerConfig.QUEUE)
    public void consumerMessageFromQueue(RabbitMqConsumerDTO rabbitMQProducerConsumerDTO){
        System.out.println("data = "+ rabbitMQProducerConsumerDTO.getId());
        System.out.println("data = "+ rabbitMQProducerConsumerDTO.getName());
    }

    @RabbitListener(queues = RabbitMqConsumerConfig.QUEUE2)
    public void consumerMessageQueue2(String message){
        System.out.println("You Have a Message: " + message);
    }
}
