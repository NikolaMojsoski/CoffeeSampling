package com.coffee.pot.assignment;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.coffee.pot.assignment.domain.Arabica;
import com.coffee.pot.assignment.domain.Robusta;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAllArabicaTest() throws Exception {
		assertThat(this.restTemplate.
				getForObject("http://localhost:" + port + "/getAllArabica",
				Arabica.class))
				.asList();
	}
	
	@Test
	public void getAllRobustaTest() throws Exception {
		assertThat(this.restTemplate.
				getForObject("http://localhost:" + port + "/getAllRobusta",
				List.class))
				.asList();
	}
}
