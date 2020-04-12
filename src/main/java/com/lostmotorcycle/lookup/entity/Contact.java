package com.lostmotorcycle.lookup.entity;

import com.lostmotorcycle.lookup.AppEntity;

import javax.persistence.Entity;

@Entity
public class Contact extends AppEntity{

	private String name;
	private String phone;
	private String email;
	private String note;

}
