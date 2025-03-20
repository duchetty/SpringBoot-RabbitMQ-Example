package com.rabbitmq.controller;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.model.Messages;

@RestController
public class Producer {
    @Autowired
    private RabbitTemplate  template;
    
//    @Autowired
//    private DirectExchange exchange;
    
//  @Autowired
 //   private FanoutExchange exchange;
    
    @Autowired
    private TopicExchange exchange;
   
   
    @PostMapping("/post")
    public String send(@RequestBody Messages message)
    {
        template.convertAndSend(exchange.getName(), "Routing_key.A",message);
        return "Message Sent Successfully";
    }
}
