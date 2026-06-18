package com.alexsander.prj_springboot_test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

//Imports estáticos necessários para o MockMvc
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(OlaController.class)
class OlaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testOla() throws Exception {
        mockMvc.perform(get("/ola"))
               .andExpect(status().isOk())
               .andExpect(content().string("Olá, mundo!"));
    }
}