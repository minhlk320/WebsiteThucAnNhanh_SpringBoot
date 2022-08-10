package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Setter
@Getter
public class Role {
	@Id
	private Long roleID;

	private String roleName;

	@ManyToMany(mappedBy = "roles")
	private Set<Account> account;

	
}