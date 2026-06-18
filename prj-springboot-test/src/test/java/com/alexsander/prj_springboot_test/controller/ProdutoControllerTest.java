package com.alexsander.prj_springboot_test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCriar() throws Exception {
        mockMvc.perform(post("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
           //   .content("\"Notebook\""))  // Se mantiver essa linha irá gerar erro, pois no controller o texto Notebook não tem ASPAS. O código abaixo está corrigido.
        		.content("Notebook"))
               .andExpect(status().isOk())
               .andExpect(content().string("Produto Notebook criado!"));
    }
}