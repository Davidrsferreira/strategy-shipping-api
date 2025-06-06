package com.drsfdev.strategy_shipping_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShippingRequest {

    @NotNull
    private String deliveryType;

    private BigDecimal weight;
}
