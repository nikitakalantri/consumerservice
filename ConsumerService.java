package com.voucher.consumer.service.service;

import java.util.List;
import java.util.Optional;

import com.voucher.consumer.service.model.ConsumerModel;

public interface ConsumerService {

	ConsumerModel save(ConsumerModel consumer);

	List<ConsumerModel> findAll(Integer pageNo, Integer pageSize, String sortBy);

	Optional<ConsumerModel> findById(int consumerId);

	List<ConsumerModel> findAll();

}
