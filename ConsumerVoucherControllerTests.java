package com.voucher.consumer.service.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.voucher.consumer.service.model.ConsumerModel;
import com.voucher.consumer.service.model.ResponseModel;
import com.voucher.consumer.service.repository.ConsumerVoucherRepository;
import com.voucher.consumer.service.serviceImpl.ConsumerVoucherServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConsumerVoucherControllerTests {
	
	@LocalServerPort
	private int port;
	
	@MockBean
	ConsumerVoucherRepository consumerVoucherRepository;
	
	@MockBean
	ConsumerVoucherServiceImpl consumerVoucherServiceImpl;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private static final ObjectMapper om = new ObjectMapper();

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFetchVouchersForConsumer() throws Exception {
		ResponseModel responseModel = new ResponseModel(12, "Gr", "Gr@gmail", 9, "Corporate", "400", "30", "");
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/api/fetchVouchersForConsumer", responseModel, String.class);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}
	
	@Test
	public void testFetchVouchersForConsumerFailure() throws Exception {
		ResponseModel responseModel = new ResponseModel(12, "Gr", "Gr@gmail", 9, "Corporate", "400", "30", "");
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/api/fetchVouchersForConsumer", responseModel, String.class);
		assertEquals(201, responseEntity.getStatusCodeValue());
	}
	
	@Test
	public void testFetchConsumer() throws JsonProcessingException, JSONException {
		List<ResponseModel> list = new ArrayList<ResponseModel>();
		ResponseModel consumerOne = new ResponseModel(12, "Gr", "Gr@gmail", 9, "Corporate", "400", "30", "");
		ResponseModel consumerTwo = new ResponseModel(3, "Riya", "Riya@gmail", 5, "Personal", "100", "50", "");
		ResponseModel consumerThree = new ResponseModel(10, "Carol", "Carol@gmail", 8, "Personal", "4030", "530", "");
		list.add(consumerOne);
		list.add(consumerTwo);
		list.add(consumerThree);
		
		Mockito.when(consumerVoucherServiceImpl.findAll()).thenReturn(list);
		String expected = om.writeValueAsString(list);
		ResponseEntity<String> response = restTemplate
				.getForEntity("http://localhost:" + port + "/api/fetchConsumersVouchers", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);
		Mockito.verify(consumerVoucherServiceImpl).findAll();

	}
	
	@Test
	public void testFetchConsumerFailure() throws JsonProcessingException, JSONException {
		List<ResponseModel> list = new ArrayList<ResponseModel>();
		ResponseModel consumerOne = new ResponseModel(12, "Gr", "Gr@gmail", 9, "Corporate", "400", "30", "");
		ResponseModel consumerTwo = new ResponseModel(3, "Riya", "Riya@gmail", 5, "Personal", "100", "50", "");
		ResponseModel consumerThree = new ResponseModel(10, "Carol", "Carol@gmail", 8, "Personal", "4030", "530", "");
		list.add(consumerOne);
		list.add(consumerTwo);
		list.add(consumerThree);
		
		Mockito.when(consumerVoucherServiceImpl.findAll()).thenReturn(list);
		String expected = om.writeValueAsString(list);
		ResponseEntity<String> response = restTemplate
				.getForEntity("http://localhost:" + port + "/api/fetchConsumersVouchers", String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);
		Mockito.verify(consumerVoucherServiceImpl).findAll();

	}

	

}
