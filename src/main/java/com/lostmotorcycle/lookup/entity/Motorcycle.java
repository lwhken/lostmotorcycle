package com.lostmotorcycle.lookup.entity;

import com.lostmotorcycle.lookup.data.Colour;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Motorcycle {
	@Id	@GeneratedValue
	private Long id;

	private String rego;
	private String vin;

	@ManyToOne
	private Make make;
	private Integer year;
	private Colour colour;
}
