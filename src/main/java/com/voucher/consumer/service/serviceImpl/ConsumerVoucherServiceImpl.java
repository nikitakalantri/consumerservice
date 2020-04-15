package com.voucher.consumer.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.voucher.consumer.service.controller.ConsumerController;
import com.voucher.consumer.service.model.ConsumerModel;
import com.voucher.consumer.service.model.ResponseModel;
import com.voucher.consumer.service.model.VoucherModel;
import com.voucher.consumer.service.repository.ConsumerVoucherRepository;
import com.voucher.consumer.service.service.ConsumerVoucherService;

@Service
public class ConsumerVoucherServiceImpl implements ConsumerVoucherService{

	@Autowired
	private ConsumerController consumerController;
	
	@Autowired
	private ConsumerVoucherRepository consumerVoucherRepository;
	
	@Override
	public ResponseModel fetchFinalRes(ResponseEntity<List<VoucherModel>> voucherDetails) {
		ResponseModel responseModel = new ResponseModel();
		List<ConsumerModel> consumerModels = new ArrayList<ConsumerModel>();
		consumerModels = consumerController.fetchConsumer();
		for (ConsumerModel consumerModel : consumerModels) {
			responseModel.setConsumerId(consumerModel.getConsumerId());
			responseModel.setConsumerName(consumerModel.getConsumerName());
			responseModel.setConsumerEmail(consumerModel.getConsumerEmail());
			//responseModel.setVoucherId(consumerModel.getConsumerName());
		}
		//List<VoucherModel> voucherModels = new ArrayList<VoucherModel>();
		List<VoucherModel> voucherRes = voucherDetails.getBody();
		for (VoucherModel voucherModel : voucherRes) {
			responseModel.setVoucherNumber(voucherModel.getVoucherNumber());
			responseModel.setVoucherType(voucherModel.getVoucherType());
			responseModel.setVoucherAmount(voucherModel.getVoucherAmount());
			responseModel.setRequestedQuantity(voucherModel.getRequestedQuantity());
		}
		consumerVoucherRepository.save(responseModel);
		return responseModel;
	}

	@Override
	public List<ResponseModel> findAll() {
		return this.consumerVoucherRepository.findAll();
	}

}