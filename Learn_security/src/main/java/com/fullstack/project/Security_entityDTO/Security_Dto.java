package com.fullstack.project.Security_entityDTO;

import java.util.Set;

import com.fullstack.project.Security_entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Security_Dto {
	
	private String username;
	private String email;
	private String password;

	private Set<Role> roles;

	
}
