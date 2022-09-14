package com.bae.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import com.bae.main.entities.SerialKiller;
import com.bae.main.services.SerialKillerServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class SerialKillerControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private SerialKillerServices service;
	
	@Test
	public void createTest() throws Exception {	

		SerialKiller input = new SerialKiller("Peter", "Sutcliffe", "Yorkshire", 13, "Gemini");
		String inputAsJSON = mapper.writeValueAsString(input);
		SerialKiller response = new SerialKiller(2L,"Peter", "Sutcliffe", "Yorkshire", 13, "Gemini");
		String responseAsJSON = mapper.writeValueAsString(response);	
		
		
		Mockito.when(service.create(input)).thenReturn(response);
		
		mvc.perform(post("/SerialKiller/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(inputAsJSON))
			.andExpect(status().isCreated())	
			.andExpect(content().json(responseAsJSON));
	}
	
	
}
