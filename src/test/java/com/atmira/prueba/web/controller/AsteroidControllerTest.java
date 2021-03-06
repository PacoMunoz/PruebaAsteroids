package com.atmira.prueba.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(AsteroidController.class)
@SpringBootTest
@AutoConfigureMockMvc
class AsteroidControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAsteroids() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/asteroids?days=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getAsteroidsParametersErrors() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/asteroids?days=0").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
}
