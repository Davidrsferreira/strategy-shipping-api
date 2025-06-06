package com.drsfdev.strategy_shipping_api;


import com.drsfdev.strategy_shipping_api.dto.ShippingRequest;
import com.drsfdev.strategy_shipping_api.dto.ShippingResponse;
import com.drsfdev.strategy_shipping_api.service.ShippingService;
import com.drsfdev.strategy_shipping_api.strategy.ShippingStrategyFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShippingServiceUnitTests {

    private final ShippingStrategyFactory strategyFactory = new ShippingStrategyFactory();
    private final ShippingService shippingService = new ShippingService(strategyFactory);

    @Test
    void testCalculateShippingNormal() {
        ShippingRequest request = new ShippingRequest();
        request.setDeliveryType("NORMAL");
        request.setWeight(new BigDecimal("10.00"));

        ShippingResponse response = shippingService.calculateShipping(request);
        assertThat(response.getCost()).isEqualByComparingTo("5.00");
    }

    @Test
    void testCalculateShippingExpress() {
        ShippingRequest request = new ShippingRequest();
        request.setDeliveryType("EXPRESS");
        request.setWeight(new BigDecimal("10.00"));

        ShippingResponse response = shippingService.calculateShipping(request);
        assertThat(response.getCost()).isEqualByComparingTo("10.00");
    }

    @Test
    void testCalculateShippingUnsupportedType() {
        ShippingRequest request = new ShippingRequest();
        request.setDeliveryType("SAME_DAY");

        assertThatThrownBy(() -> shippingService.calculateShipping(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Unsupported delivery type: SAME_DAY");
    }
}
