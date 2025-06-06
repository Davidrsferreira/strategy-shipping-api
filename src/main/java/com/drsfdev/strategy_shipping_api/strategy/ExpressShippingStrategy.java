package com.drsfdev.strategy_shipping_api.strategy;

import com.drsfdev.strategy_shipping_api.dto.ShippingRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ExpressShippingStrategy implements ShippingStrategy{

    @Override
    public String getDeliveryType() {
        return "EXPRESS";
    }

    @Override
    public BigDecimal calculate(ShippingRequest request) {
        return new BigDecimal("1.00").multiply(request.getWeight());
    }
}
