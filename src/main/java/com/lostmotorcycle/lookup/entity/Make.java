package com.lostmotorcycle.lookup.entity;

import com.lostmotorcycle.lookup.AppEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Make extends AppEntity {

	private String name;

	@OneToMany
	Set<Motorcycle> motorcycles;
}
