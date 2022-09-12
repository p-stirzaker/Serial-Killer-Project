package com.bae.main.services;

import java.util.List;

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
}
