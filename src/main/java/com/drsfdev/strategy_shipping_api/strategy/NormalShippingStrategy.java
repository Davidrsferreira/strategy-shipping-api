package com.drsfdev.strategy_shipping_api.strategy;

import com.drsfdev.strategy_shipping_api.dto.ShippingRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class NormalShippingStrategy implements ShippingStrategy{

    @Override
    public String getDeliveryType() {
        return "NORMAL";
    }

    @Override
    public BigDecimal calculate(ShippingRequest request) {
        return new BigDecimal("0.50").multiply(request.getWeight());
    }
}
