package com.bae.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

	@Test
	public void getAllTest() throws Exception {	

		List<SerialKiller> result = new ArrayList<>();

		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));

		String resultAsJSON = mapper.writeValueAsString(result);

		Mockito.when(service.getAll()).thenReturn(result);
		
		mvc.perform(get("/SerialKiller/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {	
		SerialKiller result = new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius");

		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getById(1L)).thenReturn(result);
				
		mvc.perform(get("/SerialKiller/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {	

		SerialKiller input = new SerialKiller("Rose","West", "Gloucester", 10, "Sagittarius");
		String resultAsJSON = mapper.writeValueAsString(input);

		SerialKiller response = new SerialKiller(1L,"Rose","West", "Gloucester", 10, "Sagittarius");
		String responseAsJSON = mapper.writeValueAsString(response);	
		
		Mockito.when(service.update(1L, input)).thenReturn(response);
		
		mvc.perform(put("/SerialKiller/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(resultAsJSON))
			.andExpect(status().isAccepted())	
			.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void getByFirstNameTest() throws Exception {	

		List<SerialKiller> result = new ArrayList<>();
		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));

		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getByFirstName("Dennis")).thenReturn(result);
		
		mvc.perform(get("/SerialKiller/getByFirstName/Dennis")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getBylastNameTest() throws Exception {	

		List<SerialKiller> result = new ArrayList<>();
	
		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));

		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getByLastName("Nilsen")).thenReturn(result);
		
		mvc.perform(get("/SerialKiller/getBylastName/Nilsen")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByPlace() throws Exception {	
		//Created a list
		List<SerialKiller> result = new ArrayList<>();

		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));

		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getByPlace("London")).thenReturn(result);
		
		mvc.perform(get("/SerialKiller/getBylastName/London")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByConfirmedKills() throws Exception {	

		List<SerialKiller> result = new ArrayList<>();

		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));

		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getByConfirmedKills(12)).thenReturn(result);
		
		mvc.perform(get("/SerialKiller/getBylastName/12")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByZodicSign() throws Exception {	

		List<SerialKiller> result = new ArrayList<>();

		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));

		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getByZodiacSign("Sagittarius")).thenReturn(result);
		
		mvc.perform(get("/SerialKiller/getBylastName/Sagittarius")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	
	@Test
	public void deleteTest() throws Exception {	
		Mockito.when(service.delete(1L)).thenReturn(true);
		
		mvc.perform(delete("/SerialKiller/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().string("true"));
	}
	
	@Test
	public void deleteFailTest() throws Exception {
		Mockito.when(service.delete(1L)).thenReturn(false);
		
		mvc.perform(delete("/SerialKiller/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())	
				.andExpect(content().string("false"));
	}
}
