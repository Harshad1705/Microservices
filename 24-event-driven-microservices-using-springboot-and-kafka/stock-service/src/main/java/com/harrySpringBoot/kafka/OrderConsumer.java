package com.harrySpringBoot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.harrySpringBoot.dto.OrderEvent;
import com.harrySpringBoot.entity.StockOrder;
import com.harrySpringBoot.repository.OrderRepository;

@Service
public class OrderConsumer {


    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    public OrderConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private OrderRepository orderRepository;

    @KafkaListener(topics = "${spring.kafka.topic.name}" , groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(OrderEvent event) {
        
        LOGGER.info(String.format("Order Event Received in Stock Service -> %s", event.getOrder()));

        // save the order event into database 
        StockOrder stockOrder = new StockOrder();
        stockOrder.setName(event.getOrder().getName());
        stockOrder.setOrderId(event.getOrder().getOrderId());
        stockOrder.setPrice(event.getOrder().getPrice());
        stockOrder.setQty(event.getOrder().getQty());
        orderRepository.save(stockOrder); 
        
    }

}
