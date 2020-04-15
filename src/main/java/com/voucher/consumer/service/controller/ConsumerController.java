package com.voucher.consumer.service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.voucher.consumer.service.model.ConsumerModel;
import com.voucher.consumer.service.service.ConsumerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;

	@ApiOperation(value = "Create consumer")
	@RequestMapping(value = "/createConsumer", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public ConsumerModel createConsumer(@RequestBody ConsumerModel consumer) {
		return this.consumerService.save(consumer);
	}

	@ApiOperation(value = "Fetch consumer")
	@RequestMapping(value = "/fetchConsumer", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public java.util.List<ConsumerModel> fetchConsumer() {
		return this.consumerService.findAll();
	}

	@ApiOperation(value = "Fetch consumer by id")
	@RequestMapping(value = "/fetchConsumer/{consumerId}", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 204, message = "Empty Contents"),
			@ApiResponse(code = 400, message = "Invalid request data"),
			@ApiResponse(code = 500, message = "Unknown error") })
	public Optional<ConsumerModel> fetchVoucherById(@PathVariable("consumerId") int consumerId) {
		return this.consumerService.findById(consumerId);
	}

}
