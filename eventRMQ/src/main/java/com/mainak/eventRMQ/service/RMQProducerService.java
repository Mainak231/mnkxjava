package com.mainak.eventRMQ.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RMQProducerService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate; // by default uses Jackson2JsonMessageConverter
	
	public void sendMessage(String message) {
		rabbitTemplate.convertAndSend("demoExchange","demoRK",message);
	}
	
	public void testProducer(String message) {
		sendMessage(message);
	}
}
