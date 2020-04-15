package com.voucher.consumer.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public Optional<ConsumerModel> findById(int consumerId) {
		return this.consumerRepository.findById(consumerId);
	}

	@Override
	public List<ConsumerModel> findAll(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<ConsumerModel> pagedResult = consumerRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<ConsumerModel>();
		}
	}

	@Override
	public List<ConsumerModel> findAll() {
		return (List<ConsumerModel>) this.consumerRepository.findAll();
	}

}
