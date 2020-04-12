package com.lostmotorcycle.lookup;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AppEntity{
	@Id
	@GeneratedValue
	@Getter
	@Setter(AccessLevel.PRIVATE)
	Long id;
}