package com.voucher.consumer.service.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.voucher.consumer.service.model.ConsumerModel;

@Repository
public interface ConsumerRepository extends PagingAndSortingRepository<ConsumerModel, Integer>{

}
