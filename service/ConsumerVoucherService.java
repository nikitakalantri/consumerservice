package com.voucher.consumer.service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.voucher.consumer.service.model.ConsumerModel;
import com.voucher.consumer.service.model.ResponseModel;
import com.voucher.consumer.service.model.VoucherModel;

public interface ConsumerVoucherService {

	ResponseModel fetchFinalRes(ResponseEntity<List<VoucherModel>> voucherDetails);

	List<ResponseModel> findAll();



}
