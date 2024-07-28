package com.mainak.eventRMQ.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RMQConsumerService {
	
	@RabbitListener(queues="demoQueue")
	public void recieveMessage(String message) {
		System.out.println("Recieved message: "+message);
	}
}
