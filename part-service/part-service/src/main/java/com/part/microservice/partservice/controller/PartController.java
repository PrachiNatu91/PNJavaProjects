package com.part.microservice.partservice.controller;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.part.microservice.partservice.entity.Part;
import com.part.microservice.partservice.exception.PartNotFoundException;
import com.part.microservice.partservice.service.KafkaProvider;
import com.part.microservice.partservice.service.PartService;

@RestController
public class PartController {
	
	@Autowired
	private PartService partService;
	
	@Autowired
	private KafkaProvider kafkaProducer;
	
	public PartController(PartService partService) {
		super();
		this.partService = partService;
	}



	@PostMapping("/part")
	public Part savePart(@RequestBody Part part) {
		kafkaProducer.sendMessage(part);
		return partService.savePart(part);
	}
	
	@GetMapping("/part/{id}")
	public Part getPart(@PathVariable Long id) {
		Optional<Part> partOptional = partService.getPart(id);
		Part part = partOptional.orElseThrow(() -> new PartNotFoundException());
		return part;
			
	}
	
	@GetMapping("/part")
	public List<Part> getAllParts() {
		List<Part> parts = partService.getAllParts();	
		return parts;
			
	}
}
