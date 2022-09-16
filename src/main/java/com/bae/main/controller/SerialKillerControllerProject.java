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

//import com.bae.main.entities.SerialKillerProject;
//import com.bae.main.services.SerialKillerProjectServices;




//@RestController
//@RequestMapping("/SerialKillerProject")
public class SerialKillerControllerProject {
//	private SerialKillerProjectServices service;
//	public SerialKillerProjectController(SerialKillerProjectServices service) {
//		super();
//		this.service = service;
//	}
//
//	@PostMapping("/create")
//	public ResponseEntity<SerialKillerProject> create(@RequestBody SerialKillerProject input) {
//		return new ResponseEntity<SerialKillerProject>(service.create(input), HttpStatus.CREATED);
//	}
//
//	@GetMapping("/getById/{id}")
//	public SerialKillerProject getById(@PathVariable long id) {
//		return this.service.getById(id);
//	}
//	
//	@GetMapping("/getAll")
//	public List<SerialKillerProject> getAll() {
//		return service.getAll();
//		}
//	
//	@PutMapping("/update/{id}")
//	public ResponseEntity<SerialKillerProject>update(@PathVariable long id, @RequestBody SerialKillerProject input) {
//		return new ResponseEntity<SerialKillerProject>(service.update(id, input),HttpStatus.ACCEPTED);	
//}
//	@GetMapping("/getByFirstName/{firstName}")
//	public List<SerialKillerProject> getByFirstName(@PathVariable String firstName) {
//		return service.getByFirstName(firstName);
//	}
//
//	@GetMapping("/getBylastName/{lastName}")
//	public List <SerialKillerProject> getByLastName(@PathVariable String lastName) {
//		return service.getByLastName(lastName);
//	}
//	@GetMapping("/getByPlace/{place}")
//	public List <SerialKillerProject> getByPlace(@PathVariable String place) {
//		return service.getByPlace(place);
//	}
//
//	@GetMapping("/getByConfirmedKills/{confirmedKills}")
//	public SerialKillerProject getByConfirmedKills(@PathVariable int number) {
//	return service.getByConfirmedKills(number);
//	}
//
//	@GetMapping("/getByZodiacSign/{lastName}")
//	public List <SerialKillerProject> getByZodiacSign(@PathVariable String zodiacSign) {
//		return service.getByZodiacSign(zodiacSign);
//	}
//	@DeleteMapping("/delete/{id}")
//	public boolean delete(@PathVariable long id) {
//		return service.delete(id);
//
//	}
}