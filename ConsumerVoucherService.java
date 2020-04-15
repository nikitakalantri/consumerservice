package com.voucher.consumer.service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.voucher.consumer.service.model.ResponseModel;
import com.voucher.consumer.service.model.VoucherModel;

public interface ConsumerVoucherService {

	List<ResponseModel> findAll(Integer pageNo, Integer pageSize, String sortBy);

	ResponseModel fetchFinalRes(ResponseEntity<List<VoucherModel>> voucherDetails);

}
