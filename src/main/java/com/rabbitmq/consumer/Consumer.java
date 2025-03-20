package com.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.config.RabbitMQConfig;
import com.rabbitmq.model.Messages;

@Component
public class Consumer {
	
	@RabbitListener(queues="queueA")
	public void ConsumeMessageFromQueueA(Messages message)
	{
		System.out.println("Message Received From Queue A :"+ message);
	}
	
	@RabbitListener(queues="queueB")
	public void ConsumeMessageFromQueueB(Messages message)
	{
		System.out.println("Message Received From Queue B :"+ message);
	}
	
	@RabbitListener(queues="queueAll")
	public void ConsumeMessageFromQueueAll(Messages message)
	{
		System.out.println("Message Received From Queue All :"+ message);
	}
}
