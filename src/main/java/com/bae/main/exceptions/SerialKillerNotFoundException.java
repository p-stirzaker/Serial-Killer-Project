package com.bae.main.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "This Serial Killer cannot be found with this ID")
public class SerialKillerNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 8810608716093416362L; 

}
