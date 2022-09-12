package com.bae.main.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SerialKillerProject {

@Entity
public class SerialKiller{
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
}
}