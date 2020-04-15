package com.voucher.consumer.service.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.voucher.consumer.service.model.ResponseModel;

@Repository
public interface ConsumerVoucherRepository extends PagingAndSortingRepository<ResponseModel, Integer>{

}
