package com.part.microservice.partservice.service;

import java.util.List;
import java.util.Optional;

import com.part.microservice.partservice.entity.Part;

public interface PartService {
	public Part savePart(Part part);
	public Optional<Part> getPart(Long id);
	public List<Part> getAllParts();
}
