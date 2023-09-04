package com.fullstack.project.Security_Respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.project.Security_entity.Security_entity;

@Repository
public interface Security_Repository extends JpaRepository<Security_entity, Integer>{

  
	
}
