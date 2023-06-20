package com.part.microservice.partservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.part.microservice.partservice.entity.Part;

public interface PartRepository extends JpaRepository<Part, Long>{

}
