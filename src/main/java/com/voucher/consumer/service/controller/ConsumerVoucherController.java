package com.voucher.consumer.service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.voucher.consumer.service.model.ResponseModel;
import com.voucher.consumer.service.model.VoucherModel;
import com.voucher.consumer.service.service.ConsumerVoucherService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/")
public class ConsumerVoucherController {

	@Autowired
	private ConsumerVoucherService consumerVoucherService;

	@ApiOperation(value = "Fetch voucher and associate it with consumers")
	@RequestMapping(value = "/fetchVouchersForConsumer", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public ResponseModel fetchVouchersForConsumer() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String baseUrl = "http://localhost:8090/api/v1/fetchVoucher";
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<List<VoucherModel>> voucherDetails = restTemplate.exchange(baseUrl, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<VoucherModel>>() {
				});
		ResponseModel responseModel = consumerVoucherService.fetchFinalRes(voucherDetails);
		return responseModel;
	}

	@ApiOperation(value = "Fetch consumer and its associated vouchers")
	@RequestMapping(value = "/fetchConsumersVouchers", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public java.util.List<ResponseModel> fetchConsumer() {
		return this.consumerVoucherService.findAll();
	}

}
