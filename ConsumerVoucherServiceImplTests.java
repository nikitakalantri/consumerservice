package com.voucher.consumer.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.voucher.consumer.service.model.ResponseModel;
import com.voucher.consumer.service.repository.ConsumerVoucherRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ConsumerVoucherServiceImplTests {

	@InjectMocks
	ConsumerVoucherServiceImpl consumerVoucherServiceImpl;
	
	@Mock
	ConsumerVoucherRepository consumerVoucherRepository;
	
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveTest() {
		ResponseModel responseModel = new ResponseModel(1, "Rupal", "Rupal@gmail.com", 2, "5", "Personal", "5000", "10000");
		consumerVoucherRepository.save(responseModel);
		Mockito.verify(consumerVoucherRepository).save(responseModel);
	}

	@Test
	public void findAllTest() {
		List<ResponseModel> list = new ArrayList<ResponseModel>();
		ResponseModel resOne = new ResponseModel(1, "Rupal", "Rupal@gmail.com", 2, "5", "Personal", "5000", "10000");
		ResponseModel resTwo = new ResponseModel(2, "Riya", "Riya@gmail.com", 2, "4" ,"Corporate", "500000", "78787");
		ResponseModel resThree = new ResponseModel(1, "Rainy", "Rainy@gmail.com", 4, "3","Personal", "500000", "78787");
		ResponseModel resFour = new ResponseModel(4, "Gr", "Gr@gmail.com",  1,"2", "Corporate", "500000", "78787");
		list.add(resOne);
		list.add(resTwo);
		list.add(resThree);
		list.add(resFour);
		Mockito.when(consumerVoucherRepository.findAll()).thenReturn(list);
		List<ResponseModel> responseList = consumerVoucherServiceImpl.findAll();
		assertEquals(4, responseList.size());
		Mockito.verify(consumerVoucherRepository).findAll();
	}

}
