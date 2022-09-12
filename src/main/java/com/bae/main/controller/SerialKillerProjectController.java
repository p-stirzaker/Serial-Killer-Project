package com.bae.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SerialKiller")
public class SerialKillerProjectController {
	private SerialKillerProjectServices service;
	public SerialKillerProjectController(SerialKillerProjectServices service) {
		super();
		this.serivce = service;
	}
}