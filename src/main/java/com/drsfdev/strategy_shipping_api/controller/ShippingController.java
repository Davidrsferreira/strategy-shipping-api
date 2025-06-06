package com.drsfdev.strategy_shipping_api.controller;

import com.drsfdev.strategy_shipping_api.dto.ShippingRequest;
import com.drsfdev.strategy_shipping_api.dto.ShippingResponse;
import com.drsfdev.strategy_shipping_api.service.ShippingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping("/calculate")
    public ShippingResponse calculate(@RequestBody @Valid ShippingRequest request) {
        return shippingService.calculateShipping(request);
    }
}
