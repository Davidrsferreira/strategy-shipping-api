package com.drsfdev.strategy_shipping_api.service;

import com.drsfdev.strategy_shipping_api.dto.ShippingRequest;
import com.drsfdev.strategy_shipping_api.dto.ShippingResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ShippingService {

    public ShippingResponse calculateShipping(ShippingRequest request) {
        BigDecimal cost;

        if ("NORMAL".equalsIgnoreCase(request.getDeliveryType())) {
            cost = new BigDecimal("0.50").multiply(request.getWeight());
        } else if ("EXPRESS".equalsIgnoreCase(request.getDeliveryType())) {
            cost = new BigDecimal("1.00").multiply(request.getWeight());
        } else {
            cost = new BigDecimal("0.00"); // default or unsupported
        }

        return new ShippingResponse(cost);
    }
}
