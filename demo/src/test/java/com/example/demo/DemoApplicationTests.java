package com.example.demo;

import entity.LoyaltyCard;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import service.LoyaltyCardService;
import service.impl.LoyaltyCardServiceImpl;

@SpringBootTest
class DemoApplicationTests {
	@InjectMocks
	private LoyaltyCardServiceImpl loyaltyCardService;



	@Test
	void contextLoads() {
	}

}
