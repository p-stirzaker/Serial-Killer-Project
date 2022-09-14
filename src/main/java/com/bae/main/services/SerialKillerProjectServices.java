package com.bae.main.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bae.main.entities.SerialKillerProject;
import com.bae.main.exceptions.SerialKillerNotFoundException;
import com.bae.main.repos.SerialKillerProjectRepo;


@Service
public class SerialKillerProjectServices {

	private SerialKillerProjectRepo repo;
	
	public SerialKillerProjectServices(SerialKillerProjectRepo repo) {
		super();
		this.repo = repo;
	}
	
	public SerialKillerProject create(SerialKillerProject input) {
		return repo.saveAndFlush(input);
	}
	
	public List<SerialKillerProject> getAll(){
		return repo.findAll();
	}
	
	public SerialKillerProject getById(long id) {
		return repo.findById(id).orElseThrow(SerialKillerNotFoundException::new);
	}
	
	
	public List<SerialKillerProject> getByFirstName(@PathVariable String firstName) {
		return repo.findSerialKillerByFirstName(firstName);
	}
	
	public List<SerialKillerProject> getByLastName(@PathVariable String lastName) {
		return repo.findSerialKillerByLastName(lastName);
	}
	
	public List<SerialKillerProject> getByPlace(@PathVariable String place) {
		return repo.findSerialKillerByPlace(place);
	}
	
	public SerialKillerProject getByConfirmedKills(@PathVariable int confirmedKills) {
		return repo.findSerialKillerByConfirmedKills(confirmedKills);
	}
	
	public List<SerialKillerProject> getByZodiacSign (@PathVariable String zodiacSign) {
		return repo.findSerialKillerByZodiacSign(zodiacSign);
	}
	
	public SerialKillerProject update(long id, SerialKillerProject input) {
		SerialKillerProject existing = repo.findById(id).orElseThrow(SerialKillerNotFoundException::new);
		
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
