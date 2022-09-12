package com.bae.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.main.entities.SerialKillerProject.SerialKiller;

@RestController
@RequestMapping("/SerialKiller")
public class SerialKillerProjectController {
	private SerialKillerProjectServices service;
	public SerialKillerProjectController(SerialKillerProjectServices service) {
		super();
		this.serivce = service;
	}

	@PostMapping("/create")
	public ResponseEntity<SerialKiller> create(@RequestBody SerialKiller input) {
		return new ResponseEntity<Serialkiller>(service.create(input), HttpStatus.CREATED);
	}

	@GetMapping("/getById/{id}")
	public SerialKiller getById(@PathVariable long id) {
		return this.service.getById(id);
	}
}