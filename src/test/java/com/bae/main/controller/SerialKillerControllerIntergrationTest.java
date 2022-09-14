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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.main.entities.SerialKiller;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema.sql","classpath:data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class SerialKillerControllerIntergrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		SerialKiller input = new SerialKiller("Peter", "Sutcliffe", "Yorkshire", 13, "Gemini");
		String inputAsJSON = mapper.writeValueAsString(input);
		SerialKiller response = new SerialKiller(2L, "Peter", "Sutcliffe", "Yorkshire", 13, "Gemini");
		String responseAsJSON = mapper.writeValueAsString(response);
		
		mvc.perform(post("/SerialKiller/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(inputAsJSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void getAllTest() throws Exception {	
		//Created a list
		List<SerialKiller> result = new ArrayList<>();
		//Added my expected customer to the list
		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));
		//Converted that list into JSON
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/SerialKiller/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {	
		//Created a list
		SerialKiller result = new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius");
				//Converted that list into JSON
		String resultAsJSON = mapper.writeValueAsString(result);
				
		mvc.perform(get("/SerialKiller/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {	
		// An object for sending in the body of the request
		SerialKiller input = new SerialKiller("Rose","West", "Gloucester", 10, "Sagittarius");
		String resultAsJSON = mapper.writeValueAsString(input);
		// An object for checking the response
		SerialKiller response = new SerialKiller(1L,"Rose","West", "Gloucester", 10, "Sagittarius");
		String responseAsJSON = mapper.writeValueAsString(response);	
		
		mvc.perform(put("/SerialKiller/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(resultAsJSON))
			.andExpect(status().isAccepted())	
			.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void getByFirstNameTest() throws Exception {	
		//Added my expected customer to the list
		List<SerialKiller> result = new ArrayList<>();
		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));
		//Converted that list into JSON
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/SerialKiller/getByFirstName/Dennis")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getBylastNameTest() throws Exception {	
		//Created a list
		List<SerialKiller> result = new ArrayList<>();
		//Added my expected customer to the list
		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));
		//Converted that list into JSON
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/SerialKiller/getBylastName/Nilsen")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByPlace() throws Exception {	
		//Created a list
		List<SerialKiller> result = new ArrayList<>();
		//Added my expected customer to the list
		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));
		//Converted that list into JSON
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/SerialKiller/getBylastName/London")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByConfirmedKills() throws Exception {	
		//Created a list
		List<SerialKiller> result = new ArrayList<>();
		//Added my expected customer to the list
		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));
		//Converted that list into JSON
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/SerialKiller/getBylastName/12")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByZodicSign() throws Exception {	
		//Created a list
		List<SerialKiller> result = new ArrayList<>();
		//Added my expected customer to the list
		result.add(new SerialKiller(1L, "Dennis", "Nilsen", "London", 12, "Sagittarius"));
		//Converted that list into JSON
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/SerialKiller/getBylastName/Sagittarius")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().json(resultAsJSON));
	}
	
	
	@Test
	public void deleteTest() throws Exception {	
		mvc.perform(delete("/SerialKiller/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())	
			.andExpect(content().string("true"));
	}
}
