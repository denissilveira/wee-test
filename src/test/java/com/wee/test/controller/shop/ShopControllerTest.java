package com.wee.test.controller.shop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wee.test.controller.shop.domain.entity.Shop;
import com.wee.test.controller.shop.service.ShopService;
import com.wee.test.controller.shop.web.util.RestPageImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShopControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ShopService shopService;

    private static final long TOTAL_SHOPS = 2;

    @Test
    @DisplayName("on list all shops, with{data in DB}, returns values")
    void onListAllShopsWithDataInDBReturnValues() throws Exception {
        var getRequest = get("/api/v1/shops");
        MockHttpServletResponse response = mockMvc.perform(getRequest)
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

        var shops = new ObjectMapper().readValue(response.getContentAsString(), new TypeReference<RestPageImpl<Shop>>() {});
        assertFalse(shops.isEmpty());
        assertEquals(TOTAL_SHOPS, shops.get().count());
    }

    // CRETE TESTE @Test
    void updateShopWithSuccess() throws Exception {
        var postRequest = put("/api/v1/shops");
    }

    // CRETE TESTE @Test
    void createShopWithSuccess() throws Exception {
        var postRequest = post("/api/v1/shops");
    }

}
