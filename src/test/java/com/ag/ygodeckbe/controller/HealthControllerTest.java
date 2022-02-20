package com.ag.ygodeckbe.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class HealthControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testHealthController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/health")
                        .header("User-Agent", "userAgent"))
                .andExpect(status().isOk());
    }
}
