package com.souyunku.example.springboot.rabbitmq.ack.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitConfig {

    @Bean
    public Queue QueueA() {
        return new Queue("hello");
    }

}
