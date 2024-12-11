package com.order_service.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Value("${rabbit.order.queue.name}")
    private String stockQueue;
    
    @Value("${rabbit.email.queue.name}")
    private String emailQueue;

    @Value("${rabbit.exchange.name}")
    private String exchange;
    
    @Value("${rabbit.binding.routing.key}")
    private String stockRoutingKey;

    @Value("${rabbit.binding.email.routing.key}")
    private String emailRoutingKey;

    // spring bean for queue - stock
    @Bean
    public Queue orderQueue() {
        return new Queue(stockQueue);
    }
    
    // spring bean for queue - email
    @Bean
    public Queue emailQueue() {
        return new Queue(emailQueue);
    }

    // spring bean for exchange
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    // spring bean for bindi ng between exchange and queue using routing key
    @Bean  
    public Binding stockBinding() {
        return BindingBuilder
                .bind(orderQueue())
                .to(exchange())
                .with(stockRoutingKey);
    }

    @Bean  
    public Binding emailBinding() {
        return BindingBuilder
                .bind(emailQueue())
                .to(exchange())
                .with(emailRoutingKey);
    }
    
    // message coverter
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    // configure rabbitTemplate
    @Bean
    public AmqpTemplate ampqTempate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
