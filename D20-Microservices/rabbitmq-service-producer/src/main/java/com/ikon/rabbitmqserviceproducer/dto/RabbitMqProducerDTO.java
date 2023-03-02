package com.ikon.rabbitmqserviceproducer.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RabbitMqProducerDTO {
    private Long id;
    private String name;
}
