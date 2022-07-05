package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.web.reactive.function.client.WebClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.*;

import reactor.core.publisher.Mono;

@SpringBootTest
class DemoApplicationTests {

	private static String FOO_RESOURCE_URL = "http://localhost:3000";

	@Test
	void contextLoads() {
		assertEquals(2, 1 + 1);
	}

	@Test
	void PostTrafficPolice() {
		TrafficPoliceDTO trafficPoliceDTO = new TrafficPoliceDTO();
		trafficPoliceDTO.setId((long) 23);
		trafficPoliceDTO.setName("test");
		trafficPoliceDTO.setIdSecretary("test");
		trafficPoliceDTO.setYearsExperience(1.0);
		trafficPoliceDTO.setHighway(2);
		TrafficPoliceDTO aux2 = WebClient.create(FOO_RESOURCE_URL).post()
				.uri("/trafficpolice").body(Mono.just(trafficPoliceDTO), TrafficPoliceDTO.class).retrieve()
				.bodyToMono(TrafficPoliceDTO.class).block();
		assertEquals("test", aux2.getName());
	}
}
