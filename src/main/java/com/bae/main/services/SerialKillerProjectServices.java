package com.bae.main.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.bae.main.entities.SerialKillerProject.SerialKiller;

public class SerialKillerProjectServices {

	private SerialKillerProjectRepo;
	
	public SerialKillerProjectServices(SerialKillerProjectRepo repo) {
		super();
		this.repo = repo;
	}
	
	public SerialKiller create(SerialKiller input) {
		return repo.saveAndFlush(input);
	}
	
	public List<SerialKiller> getAll(){
		return repo.findAll();
	}
	
	public SerialKiller getById(long id) {
		return repo.findById(id).orElseThrow(SerialKillerNotFoundException::new);
	}
	
	public SerialKiller update(long id, SerialKiller input) {
		SerialKiller existing = repo.findById(id).orElseThrow(SerialKillerNotFoundException::new);
		
	}
	
	public List<SerialKiller> getByFirstName(@PathVariable String firstName) {
		return repo.findSerialKillerByFirstName(firstName);
	}
	
	public List<SerialKiller> getByLastName(@PathVariable String lastName) {
		return repo.findSerialKillerByLastName(lastName);
	}
	
	public List<SerialKiller> getByPlace(@PathVariable String place) {
		return repo.findSerialKillerByPlace(place);
	}
	public SerialKiller getByConfirmedKills(@PathVariable int confirmedKills) {
		return repo.findSerialKillerByConfirmedKills(confirmedKills);
	}
	public List<SerialKiller> getByZodiacSign (@PathVariable String zodiacSign) {
		return repo.findSerialKillerByZodiacSign(zodiacSign);
	}
}
