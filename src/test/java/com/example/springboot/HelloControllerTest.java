package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/welcome").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}

	@Test
	public void unzipFiles_Test() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/unzip").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void readCSV_Test() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/readcsv").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void missingFiles_Test() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/missingfiles").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
