package com.part.microservice.partservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.part.microservice.partservice.entity.Part;
import com.part.microservice.partservice.repository.PartRepository;

@Service
public class PartServiceImpl implements PartService{

	
	private PartRepository partRepository;
	
	
	public PartServiceImpl(PartRepository partRepository) {
		this.partRepository = partRepository;
	}

	@Override
	public Part savePart(Part part) {
		return partRepository.save(part);
	}

	@Override
	public Optional<Part> getPart(Long id) {
		return partRepository.findById(id);
	}

	@Override
	public List<Part> getAllParts() {
		return partRepository.findAll();
	}
	
	
	
}
