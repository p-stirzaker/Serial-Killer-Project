package com.bae.main.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SerialKillerProject{
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

	public SerialKillerProject() {
		super();
	}
	
	public SerialKillerProject(String firstName, String lastName, String place, int confirmedKills, String zodiacSign) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.place = place;
		this.confirmedKills = confirmedKills;
		this.zodiacSign = zodiacSign;

	}

	// Used for reading
	public SerialKillerProject(long id, String firstName, String lastName, String place, int confirmedKills, String zodiacSign) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.place = place;
		this.confirmedKills = confirmedKills;
		this.zodiacSign = zodiacSign;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getConfirmedKills() {
		return confirmedKills;
	}

	public void setConfirmedKills(int confirmedKills) {
		this.confirmedKills = confirmedKills;
	}

	public String getZodiacSign() {
		return zodiacSign;
	}

	public void setZodiacSign(String zodiacSign) {
		this.zodiacSign = zodiacSign;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, place, confirmedKills, zodiacSign);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SerialKillerProject other = (SerialKillerProject) obj;
		return id == other.id && Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName) && Objects.equals(place, other.place) && confirmedKills == other.confirmedKills && Objects.equals(zodiacSign, other.zodiacSign);
	}
}
