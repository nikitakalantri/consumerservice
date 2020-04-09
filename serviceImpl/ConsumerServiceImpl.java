package com.voucher.consumer.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voucher.consumer.service.model.ConsumerModel;
import com.voucher.consumer.service.repository.ConsumerRepository;
import com.voucher.consumer.service.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	private ConsumerRepository consumerRepository;

	@Override
	public ConsumerModel save(ConsumerModel consumer) {
		return this.consumerRepository.save(consumer);
	}

	@Override
	public List<ConsumerModel> findAll() {
		return this.consumerRepository.findAll();
	}

	@Override
	public Optional<ConsumerModel> findById(int consumerId) {
		return this.consumerRepository.findById(consumerId);
	}

}
