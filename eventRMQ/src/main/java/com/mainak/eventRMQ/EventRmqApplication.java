package com.mainak.eventRMQ;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventRmqApplication implements CommandLineRunner{
	
	@Value("${spring.rabbitmq.port}")
	private String port;
	
	public static void main(String[] args) {
		SpringApplication.run(EventRmqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("eventRMQ / Appln is running with port: "+port);
	}

}
