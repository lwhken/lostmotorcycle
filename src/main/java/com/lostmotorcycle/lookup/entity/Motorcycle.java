package com.lostmotorcycle.lookup.entity;

import com.lostmotorcycle.lookup.AppEntity;
import com.lostmotorcycle.lookup.data.Colour;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Motorcycle extends AppEntity {

	private String rego;
	private String vin;

	@ManyToOne
	private Make make;
	private Integer year;
	private Colour colour;

	@OneToOne
	private Contact contact;
}
