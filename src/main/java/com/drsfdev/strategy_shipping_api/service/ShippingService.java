package com.drsfdev.strategy_shipping_api.service;

import com.drsfdev.strategy_shipping_api.dto.ShippingRequest;
import com.drsfdev.strategy_shipping_api.dto.ShippingResponse;
import com.drsfdev.strategy_shipping_api.strategy.ShippingStrategy;
import com.drsfdev.strategy_shipping_api.strategy.ShippingStrategyFactory;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private final ShippingStrategyFactory strategyFactory;

    public ShippingService(ShippingStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    public ShippingResponse calculateShipping(ShippingRequest request) {
        ShippingStrategy strategy = strategyFactory.getStrategy(request.getDeliveryType());
        return new ShippingResponse(strategy.calculate(request));
    }
}
