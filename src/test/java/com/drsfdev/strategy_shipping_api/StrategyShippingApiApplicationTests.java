package com.drsfdev.strategy_shipping_api;

import com.drsfdev.strategy_shipping_api.service.ShippingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class StrategyShippingApiApplicationTests {

	@Autowired
	private ShippingService shippingService;

	@Test
	void contextLoads() {
		assertThat(shippingService).isNotNull();
	}

}
