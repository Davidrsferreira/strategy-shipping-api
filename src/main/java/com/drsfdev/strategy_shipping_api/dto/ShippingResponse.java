package com.drsfdev.strategy_shipping_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ShippingResponse {

    BigDecimal cost;
}
