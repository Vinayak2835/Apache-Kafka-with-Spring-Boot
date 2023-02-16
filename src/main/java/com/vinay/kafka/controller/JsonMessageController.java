package com.vinay.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.kafka.payload.User;
import com.vinay.kafka.service.JsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;

	@PostMapping("/publish")
	public ResponseEntity<String> send(@RequestBody User user) {

		jsonKafkaProducer.sendMessage(user);

		return ResponseEntity.ok("JsonMessage sent successfully");
	}

}
