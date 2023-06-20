package com.part.microservice.partservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class PartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartServiceApplication.class, args);
	}
	
	@Bean
	public NewTopic buildTopic() {
		return TopicBuilder.name("topic1").build();
	}

}
