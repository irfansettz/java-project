package com.ikon.rabbitmqserviceconsumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConsumerConfig {
    // route 1
    public static final String EXCHANGE = "producer_consumer_exchange";
    public static final String QUEUE = "producer_consumer_queue";
    public static final String ROUTING_KEY = "producer_consumer_routing_key";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }


    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    // route 2
    public static final String EXCHANGE2 = "producer_consumer_exchange2";
    public static final String QUEUE2 = "producer_consumer_queue2";
    public static final String ROUTING_KEY2 = "producer_consumer_routing_key2";

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE2);
    }


    @Bean
    public TopicExchange exchange2() {
        return new TopicExchange(EXCHANGE2);
    }


    @Bean
    public Binding binding2(Queue queue2, TopicExchange exchange2) {
        return BindingBuilder.bind(queue2).to(exchange2).with(ROUTING_KEY2);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

//    @Value("${spring.rabbitmq.host}")
//    private String rabbitMQHost;
//
//    @Value("${spring.rabbitmq.port}")
//    private int rabbitMQPort;
    @Value("${spring.rabbitmq.host}")
    private String rabbitMQHost;

    @Value("${spring.rabbitmq.port}")
    private int rabbitMQPort;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitMQHost);
        connectionFactory.setPort(rabbitMQPort);
        return connectionFactory;
    }
}
