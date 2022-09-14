package com.bae.main.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.main.entities.SerialKiller;
import com.bae.main.services.SerialKillerServices;

@RestController
	@RequestMapping("/SerialKiller")
	public class SerialKillerController {
		private SerialKillerServices service;
		public SerialKillerController(SerialKillerServices service) {
			super();
			this.service = service;
		}

		@PostMapping("/create")
		public ResponseEntity<SerialKiller> create(@RequestBody SerialKiller input) {
			return new ResponseEntity<SerialKiller>(service.create(input), HttpStatus.CREATED);
		}

		@GetMapping("/getById/{id}")
		public SerialKiller getById(@PathVariable long id) {
			return this.service.getById(id);
		}
		
		@GetMapping("/getAll")
		public List<SerialKiller> getAll() {
			return service.getAll();
			}
		
		@PutMapping("/update/{id}")
		public ResponseEntity<SerialKiller>update(@PathVariable long id, @RequestBody SerialKiller input) {
			return new ResponseEntity<SerialKiller>(service.update(id, input),HttpStatus.ACCEPTED);	
	}
		@GetMapping("/getByFirstName/{firstName}")
		public List<SerialKiller> getByFirstName(@PathVariable String firstName) {
			return service.getByFirstName(firstName);
		}

		@GetMapping("/getBylastName/{lastName}")
		public List <SerialKiller> getByLastName(@PathVariable String lastName) {
			return service.getByLastName(lastName);
		}
		@GetMapping("/getByPlace/{place}")
		public List <SerialKiller> getByPlace(@PathVariable String place) {
			return service.getByPlace(place);
		}

		@GetMapping("/getByConfirmedKills/{confirmedKills}")
		public SerialKiller getByConfirmedKills(@PathVariable int number) {
		return service.getByConfirmedKills(number);
		}

		@GetMapping("/getByZodiacSign/{lastName}")
		public List <SerialKiller> getByZodiacSign(@PathVariable String zodiacSign) {
			return service.getByZodiacSign(zodiacSign);
		}
		@DeleteMapping("/delete/{id}")
		public boolean delete(@PathVariable long id) {
			return service.delete(id);

		}
	}

