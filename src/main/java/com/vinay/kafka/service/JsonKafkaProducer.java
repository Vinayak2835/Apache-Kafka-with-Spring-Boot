package com.vinay.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.vinay.kafka.payload.User;

@Service
public class JsonKafkaProducer {
    
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	private static Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

	public void sendMessage(User data) {

		logger.info(String.format("Message sent -> %s", data.toString()));

		Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "JavaGuidess").build();

		kafkaTemplate.send(message);
	}
}
