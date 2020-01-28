package com.sebnsab.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebnsab.demo.controller.json.JsonController;
import com.sebnsab.demo.model.relationship.Product;
import com.sebnsab.demo.model.relationship.Transaction;
import com.sebnsab.demo.repository.ProductRepository;
import com.sebnsab.demo.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JsonController.class)
public class SpringWebMVCDemoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductRepository productRepository;

    @MockBean
    TransactionRepository transactionRepository;


    @Test
    public void mockMvcGetTest() throws Exception {

        Product product = new Product("test");

        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(product));

        String jsonString = new ObjectMapper().writeValueAsString(product);
        jsonString = "asdfasdf";

        mockMvc.perform( MockMvcRequestBuilders
                .get("/products/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").exists());
        
    }
}
