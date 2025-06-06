package com.drsfdev.strategy_shipping_api.strategy;

import com.drsfdev.strategy_shipping_api.dto.ShippingRequest;

import java.math.BigDecimal;

public interface ShippingStrategy {
    String getDeliveryType();
    BigDecimal calculate(ShippingRequest request);
}
