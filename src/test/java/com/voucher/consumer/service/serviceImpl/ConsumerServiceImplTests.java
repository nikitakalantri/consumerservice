package com.voucher.consumer.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.voucher.consumer.service.model.ConsumerModel;
import com.voucher.consumer.service.repository.ConsumerRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ConsumerServiceImplTests {

	@InjectMocks
	ConsumerServiceImpl consumerServiceImpl;

	@Mock
	ConsumerRepository consumerRepository;

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findAllTest() {
		List<ConsumerModel> list = new ArrayList<ConsumerModel>();
		ConsumerModel consumerOne = new ConsumerModel(1, "Rupal", "Rupal@gmail.com", "5");
		ConsumerModel consumerTwo = new ConsumerModel(2, "Riya", "Riya@gmail.com", "4");
		ConsumerModel consumerThree = new ConsumerModel(1, "Rainy", "Rainy@gmail.com", "3");
		ConsumerModel consumerFour = new ConsumerModel(4, "Gr", "Gr@gmail.com", "2");
		list.add(consumerOne);
		list.add(consumerTwo);
		list.add(consumerThree);
		list.add(consumerFour);
		Mockito.when(consumerRepository.findAll()).thenReturn(list);
		List<ConsumerModel> voucherList = consumerServiceImpl.findAll();
		assertEquals(4, voucherList.size());
		Mockito.verify(consumerRepository).findAll();
	}

	@Test
	public void findByIdTest() {
		Optional<ConsumerModel> ConsumerModel = Optional.of(new ConsumerModel(1, "Rupal", "Rupal@gmail.com", "5"));
		Mockito.when(consumerRepository.findById(1)).thenReturn(ConsumerModel);
		Optional<ConsumerModel> consumer = consumerServiceImpl.findById(1);
		assertEquals("Rupal", consumer.get().getConsumerName());
		assertEquals("Rupal@gmail.com", consumer.get().getConsumerEmail());
		assertEquals("5", consumer.get().getVoucherId());
	}

	@Test
	public void saveTest() {
		ConsumerModel consumerModel = new ConsumerModel(1, "Rupal", "Rupal@gmail.com", "5");
		consumerServiceImpl.save(consumerModel);
		Mockito.verify(consumerRepository).save(consumerModel);
	}

}
