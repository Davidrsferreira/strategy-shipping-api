package com.drsfdev.strategy_shipping_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ShippingControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCalculateShippingApi_Normal() throws Exception {
        String requestJson = "{" +
                "\"deliveryType\":\"NORMAL\"," +
                "\"weight\":5.0}";

        mockMvc.perform(post("/shipping/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cost").value(2.50));
    }

    @Test
    void testCalculateShippingApi_Express() throws Exception {
        String requestJson = "{" +
                "\"deliveryType\":\"EXPRESS\"," +
                "\"weight\":3.0}";

        mockMvc.perform(post("/shipping/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cost").value(3.00));
    }

    @Test
    void testCalculateShippingApi_InvalidInput() throws Exception {
        String requestJson = "{" +
                "\"weight\":2.0}";

        mockMvc.perform(post("/shipping/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }
}
