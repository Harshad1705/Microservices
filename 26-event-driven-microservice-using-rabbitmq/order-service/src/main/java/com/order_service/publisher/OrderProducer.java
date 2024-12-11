package com.order_service.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.order_service.dto.OrderEvent;

@Service
public class OrderProducer {


    private Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    @Value("${rabbit.exchange.name}")
    private String exchange;
    
    @Value("${rabbit.binding.routing.key}")
    private String stockRoutingKey;

    @Value("${rabbit.binding.email.routing.key}")
    private String emailRoutingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order event sent to RabbitMQ -> %s", orderEvent));

        // send an order event to stock queue
        rabbitTemplate.convertAndSend(exchange, stockRoutingKey, orderEvent);
        // send an order event to email queue
        rabbitTemplate.convertAndSend(exchange, emailRoutingKey, orderEvent);
        
    }

}
