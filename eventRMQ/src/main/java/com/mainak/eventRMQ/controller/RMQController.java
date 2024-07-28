package com.mainak.eventRMQ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainak.eventRMQ.service.RMQProducerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/rmq-event")
@CrossOrigin(value = "*")
public class RMQController {
	
	private static final Logger logger = LoggerFactory.getLogger(RMQController.class);
	
	@Autowired
	private RMQProducerService rmqP;
	
	@GetMapping("/test")
	public ResponseEntity<String> testApi(){
		logger.info("Application is up");
		return new ResponseEntity<String>("Application is up!!",HttpStatus.OK);
	}
	
	@GetMapping("/test-mq/{message}")
	public ResponseEntity<String> testMQ(@PathVariable("message") String message){
		logger.info("< ========= Calling producer ========= >");
		rmqP.testProducer(message);
		return new ResponseEntity<String>("Producer (initiated message)",HttpStatus.OK);
	}
}
