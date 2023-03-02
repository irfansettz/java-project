package com.ikon.rabbitmqserviceconsumer.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RabbitMqConsumerDTO implements Serializable {
    private long id;
    private String name;
}
