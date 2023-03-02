package com.ikon.rabbitmqserviceproducer.controller;

import com.ikon.rabbitmqserviceproducer.config.RabbitMqProducerConfig;
import com.ikon.rabbitmqserviceproducer.dto.RabbitMqProducerDTO;
import com.ikon.rabbitmqserviceproducer.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/rabbitmq-producer")
@RequiredArgsConstructor
@Slf4j
public class RabbitMqProducerController {
    private final RabbitTemplate rabbitTemplate;
    @PostMapping("/send-data")
    public ResponseEntity<ResponseDTO> sendDataFromProducer(@RequestBody RabbitMqProducerDTO rabbitMQProducerConsumerDTO) {
        log.info("Data will be sent, the data : {}", rabbitMQProducerConsumerDTO);
        rabbitTemplate.convertAndSend(RabbitMqProducerConfig.QUEUE, RabbitMqProducerConfig.ROUTING_KEY, rabbitMQProducerConsumerDTO);
        log.info("Data has been sent");
        return new ResponseEntity<>(ResponseDTO.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("data is created")
                .build(), HttpStatus.CREATED);
    }

    @GetMapping("/send-data")
    public String sendQueue2(@RequestParam("message") String message){
        rabbitTemplate.convertAndSend(RabbitMqProducerConfig.QUEUE2, RabbitMqProducerConfig.ROUTING_KEY2, message);
        return "Your Message is " + message;
    }
}
