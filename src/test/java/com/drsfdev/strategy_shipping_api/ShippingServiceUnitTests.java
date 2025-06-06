package com.drsfdev.strategy_shipping_api;


import com.drsfdev.strategy_shipping_api.dto.ShippingRequest;
import com.drsfdev.strategy_shipping_api.dto.ShippingResponse;
import com.drsfdev.strategy_shipping_api.service.ShippingService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ShippingServiceUnitTests {

    private final ShippingService shippingService = new ShippingService();

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

        ShippingResponse response = shippingService.calculateShipping(request);
        assertThat(response.getCost()).isEqualByComparingTo("0.00");
    }
}
