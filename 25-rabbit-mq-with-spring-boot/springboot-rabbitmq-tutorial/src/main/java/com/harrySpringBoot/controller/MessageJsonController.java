package com.harrySpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harrySpringBoot.dto.User;
import com.harrySpringBoot.publisher.RabbitMQJsonProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    @Autowired
    private RabbitMQJsonProducer jsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        jsonProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMq .....");
    }
    
}
