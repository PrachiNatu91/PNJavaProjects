package com.part.microservice.partservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.part.microservice.partservice.entity.Part;

@Service
public class KafkaProvider {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		kafkaTemplate.send("topic1", message);
	}
	
	public void sendMessage(Part part) {
		Message<Part> message = MessageBuilder.withPayload(part).setHeader(KafkaHeaders.TOPIC, "topic1").build();
		kafkaTemplate.send(message);
	}
}
