package com.drsfdev.strategy_shipping_api.strategy;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ShippingStrategyFactory {

    private final List<ShippingStrategy> strategies;
    private Map<String, ShippingStrategy> strategyMap;

    public ShippingStrategyFactory() {
        this.strategies = List.of(new NormalShippingStrategy(), new ExpressShippingStrategy());
        this.strategyMap = strategies.stream().collect(Collectors.toMap(ShippingStrategy::getDeliveryType, Function.identity()));
    }

    @PostConstruct
    public void init() {
        strategyMap = strategies.stream().collect(Collectors.toMap(ShippingStrategy::getDeliveryType, Function.identity()));
    }

    public ShippingStrategy getStrategy(String deliveryType) {
        ShippingStrategy strategy = strategyMap.get(deliveryType.toUpperCase());

        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported delivery type: " + deliveryType);
        }

        return strategy;
    }
}
