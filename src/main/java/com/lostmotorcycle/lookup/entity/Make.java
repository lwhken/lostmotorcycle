package com.lostmotorcycle.lookup.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Make {
	@Id	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany
	Set<Motorcycle> motorcycles;
}
