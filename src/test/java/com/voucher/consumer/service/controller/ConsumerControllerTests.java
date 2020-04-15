package com.voucher.consumer.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.voucher.consumer.service.model.ConsumerModel;
import com.voucher.consumer.service.repository.ConsumerRepository;
import com.voucher.consumer.service.serviceImpl.ConsumerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConsumerControllerTests {

	@LocalServerPort
	private int port;

	@MockBean
	ConsumerRepository consumerRepository;

	@MockBean
	ConsumerServiceImpl consumerServiceImpl;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private static final ObjectMapper om = new ObjectMapper();

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateConsumer() throws Exception {
		ConsumerModel consumerModel = new ConsumerModel(3, "Riya", "Riya@gmail", "5");
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/api/v1/createConsumer", consumerModel, String.class);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	public void testCreateConsumerFailure() throws Exception {
		ConsumerModel consumerModel = new ConsumerModel(3, "Riya", "Riya@gmail", "5");
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/api/v1/createConsumer", consumerModel, String.class);
		assertEquals(201, responseEntity.getStatusCodeValue());
	}

	@Test
	public void testFetchConsumer() throws Exception {
		List<ConsumerModel> list = new ArrayList<ConsumerModel>();
		ConsumerModel consumerOne = new ConsumerModel(3, "Riya", "Riya@gmail", "5");
		ConsumerModel consumerTwo = new ConsumerModel(6, "Rainy", "Rainy@gmail", "6");
		ConsumerModel consumerThree = new ConsumerModel(8, "Saujanya", "Saujanya@gmail", "7");
		ConsumerModel consumerFour = new ConsumerModel(10, "Carol", "Carol@gmail", "8");
		ConsumerModel consumerFive = new ConsumerModel(13, "Gr", "Gr@gmail", "9");

		list.add(consumerOne);
		list.add(consumerTwo);
		list.add(consumerThree);
		list.add(consumerFour);
		list.add(consumerFive);
		

		Mockito.when(consumerServiceImpl.findAll()).thenReturn(list);
		String expected = om.writeValueAsString(list);
		ResponseEntity<String> response = restTemplate
				.getForEntity("http://localhost:" + port + "/api/v1/fetchConsumer", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);
		Mockito.verify(consumerServiceImpl).findAll();
	}

	@Test
	public void testFetchConsumerFailure() throws Exception {
		List<ConsumerModel> list = new ArrayList<ConsumerModel>();
		ConsumerModel consumerOne = new ConsumerModel(3, "Riya", "Riya@gmail", "5");
		ConsumerModel consumerTwo = new ConsumerModel(6, "Rainy", "Rainy@gmail", "6");
		ConsumerModel consumerThree = new ConsumerModel(8, "Saujanya", "Saujanya@gmail", "7");
		list.add(consumerOne);
		list.add(consumerTwo);
		list.add(consumerThree);
		
		Mockito.when(consumerServiceImpl.findAll()).thenReturn(list);
		String expected = om.writeValueAsString(list);
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/api/v1/fetchConsumer",
				String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);
		Mockito.verify(consumerServiceImpl).findAll();
	}
	
	@Test
	public void testFetchVoucherById() throws JSONException {
		Optional<ConsumerModel> ConsumerModel =  Optional.of(new ConsumerModel(3, "Riya", "Riya@gmail", "5"));
		ResponseEntity<String> responseEntity = restTemplate
				.getForEntity("http://localhost:" + port + "/api/v1/fetchConsumer/1", String.class);
		Mockito.when(consumerRepository.findById(1)).thenReturn(ConsumerModel);
		Optional<ConsumerModel> consumer = consumerServiceImpl.findById(1);
		assertEquals("Riya", consumer.get().getConsumerName());
		assertEquals("Riya@gmail", consumer.get().getConsumerEmail());
		assertEquals("5", consumer.get().getVoucherId());
	}
	
}
