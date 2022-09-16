package com.bae.main.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bae.main.entities.SerialKiller;
import com.bae.main.exceptions.SerialKillerNotFoundException;
import com.bae.main.repos.SerialKillerRepo;


@Service
public class SerialKillerServices {

	private SerialKillerRepo repo;
	
	public SerialKillerServices(SerialKillerRepo repo) {
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
	
	
	public List<SerialKiller> getByFirstName(@PathVariable String firstName) {
		return repo.findSerialKillerByFirstName(firstName);
	}
	
	public List<SerialKiller> getByLastName(@PathVariable String lastName) {
		return repo.findSerialKillerByLastName(lastName);
	}
	
	public List<SerialKiller> getByPlace(@PathVariable String place) {
		return repo.findSerialKillerByPlace(place);
	}
	
	public List<SerialKiller> getByConfirmedKills(@PathVariable int confirmedKills) {
		return repo.findSerialKillerByConfirmedKills(confirmedKills);
	}
	
	public List<SerialKiller> getByZodiacSign (@PathVariable String zodiacSign) {
		return repo.findSerialKillerByZodiacSign(zodiacSign);
	}
	
	public SerialKiller update(long id, SerialKiller input) {
		SerialKiller existing = repo.findById(id).orElseThrow(SerialKillerNotFoundException::new);
		
		existing.setFirstName(input.getFirstName());
		existing.setLastName(input.getLastName());
		existing.setPlace(input.getPlace());
		existing.setConfirmedKills(input.getConfirmedKills());
		existing.setZodiacSign(input.getZodiacSign());
		
		return repo.saveAndFlush(existing);
	}
	
	public boolean delete(long id) {
		repo.deleteById(id);
		
		return !repo.existsById(id);
	}
}
