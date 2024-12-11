package com.harrySpringBoot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.harrySpringBoot.dto.OrderEvent;


@Service
public class OrderConsumer {


    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);



    @KafkaListener(topics = "${spring.kafka.topic.name}" , groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(OrderEvent event) {
        
        LOGGER.info(String.format("Order Event Received in Email Service -> %s", event.getOrder()));


        // send an email to the customer
        
    }

}