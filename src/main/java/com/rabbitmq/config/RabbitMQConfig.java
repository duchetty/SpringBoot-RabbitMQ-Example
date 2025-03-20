package com.rabbitmq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {

   
    @Bean
    public Queue queueA()
    {
        return new Queue("queueA");
    }
    @Bean
    public Queue queueB()
    {
        return new Queue("queueB");
    }
    
    @Bean
    public Queue queueAll()
    {
    	return new Queue("queueAll");
    }
    // DirectExchange

    /*@Bean
    public DirectExchange exchange()
    {
        return new DirectExchange("DirectExchage");
    }

    @Bean
    public Binding bindingA(Queue queueA, DirectExchange exchange)
    {
        return BindingBuilder.bind(queueA).to(exchange).with("Rountin_key.A");
    }
    
    @Bean
    public Binding bindingB(Queue queueB, DirectExchange exchange)
    {
        return BindingBuilder.bind(queueB).to(exchange).with("Rountin_key.B");
    }*/
    
    
    // FanoutExchange
   /* @Bean
    public FanoutExchange exchange()
    {
        return new FanoutExchange("FanoutExchange");
    }

    @Bean
    public Binding bindingA(Queue queueA, FanoutExchange exchange)
    {
        return BindingBuilder.bind(queueA)
        		.to(exchange);
        		
    }
    
    @Bean
    public Binding bindingB(Queue queueB, FanoutExchange exchange)
    {
        return BindingBuilder.bind(queueB).to(exchange);
    }*/
    
    //TopicExchange

    @Bean
    public TopicExchange exchange()
    {
    	return new TopicExchange("topicExchange");
    }
    
    @Bean
    public Binding bindingA(Queue queueA, TopicExchange exchange)
    {
        return BindingBuilder.bind(queueA)
        		.to(exchange).with("Routing_key.A");
        		
    }
    
    @Bean
    public Binding bindingB(Queue queueB, TopicExchange exchange)
    {
        return BindingBuilder.bind(queueB).to(exchange).with("Routing_key.B");
    }
    
    @Bean
    public Binding bindingAll(Queue queueAll, TopicExchange exchange)
    {
        return BindingBuilder.bind(queueAll).to(exchange).with("Routing_key.*");
    }
    
    
    
  
    @Bean
    public MessageConverter converter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory,MessageConverter converter)
    {
        RabbitTemplate rabbitTemplate=new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;

    }

}
