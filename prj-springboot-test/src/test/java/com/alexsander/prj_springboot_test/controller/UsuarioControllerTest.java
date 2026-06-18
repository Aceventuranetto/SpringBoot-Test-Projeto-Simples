package com.alexsander.prj_springboot_test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testListar() throws Exception {
        mockMvc.perform(get("/usuarios"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0]").value("Ana"))
               .andExpect(jsonPath("$[1]").value("João"))
               .andExpect(jsonPath("$[2]").value("Maria")); // Adicionado Maria para validar a lista completa!
    }
}