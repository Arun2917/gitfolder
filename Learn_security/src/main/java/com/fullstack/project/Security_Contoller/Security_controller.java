package com.fullstack.project.Security_Contoller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//mport org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.project.Security_Respository.Security_Repository;
import com.fullstack.project.Security_entity.Erole;
import com.fullstack.project.Security_entity.Role;
import com.fullstack.project.Security_entity.Security_entity;
//import com.fullstack.project.Security_entity.Security_entity;
import com.fullstack.project.Security_entityDTO.Security_Dto;

import jakarta.validation.Valid;


@RestController

public class Security_controller {
	
	@Autowired
	
  Security_Repository security_repo;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@PostMapping("/home")
	public ResponseEntity<?> createuser(@Valid @RequestBody Security_Dto security_dto){
				
		Set<Role>roles= security_dto.getRoles().stream()
				.map(role->Role.builder().name((Erole.valueOf(null))).build()).collect(Collectors.toSet());
				
				
		        Security_entity secure=Security_entity.builder().
				username(security_dto.getUsername()).email(security_dto.getEmail()).
				password(security_dto.getPassword())
				.roles(roles).
				build();
		        System.err.println(secure);
			  
		security_repo.save(secure);
		
		return ResponseEntity.ok(roles);
	}

}
