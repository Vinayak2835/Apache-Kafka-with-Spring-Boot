package com.vinay.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.kafka.service.KafkaProducers;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {
	
	@Autowired
	private KafkaProducers kafkaProducers;
	
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		
		kafkaProducers.sendMessage(message);
		
		return ResponseEntity.ok("Message sent to the topiccc");
	}
}
