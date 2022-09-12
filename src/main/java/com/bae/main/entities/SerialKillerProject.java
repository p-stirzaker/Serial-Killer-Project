package com.bae.main.entities;

import javax.persistence.Column;
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

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String place;

	@Column(nullable = false)
	private int confirmedKills;

	@Column(nullable = false)
	private String zodiacSign;

	public SerialKiller() {
		super();
	}
}
}