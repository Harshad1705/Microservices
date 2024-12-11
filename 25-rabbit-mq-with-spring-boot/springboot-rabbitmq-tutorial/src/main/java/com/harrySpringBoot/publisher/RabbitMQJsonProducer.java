package com.harrySpringBoot.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.harrySpringBoot.dto.User;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.routing.json.key}")
    private String jsonRoutingKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
      
    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(User user) {
        LOGGER.info(String.format("Json message sent -> %s", user.toString() ));
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, user);
    }
}
