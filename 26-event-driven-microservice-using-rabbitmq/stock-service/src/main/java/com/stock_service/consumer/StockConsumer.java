package com.stock_service.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.stock_service.dto.OrderEvent;

@Service
public class StockConsumer {

    private Logger LOGGER = LoggerFactory.getLogger(StockConsumer.class);

    @RabbitListener(queues = "${rabbit.order.queue.name}")
    public void consume(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order event received -> %s", orderEvent));
        
        // save order data into database
    }

}
