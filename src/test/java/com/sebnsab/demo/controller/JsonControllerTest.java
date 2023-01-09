package com.sebnsab.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebnsab.demo.bootstrap.DataLoaderCommandLine;
import com.sebnsab.demo.controller.json.JsonController;
import com.sebnsab.demo.model.relationship.Product;
import com.sebnsab.demo.model.relationship.Transaction;
import com.sebnsab.demo.repository.ProductRepository;
import com.sebnsab.demo.repository.TransactionRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JsonController.class)
@AutoConfigureMockMvc(addFilters = false)  // Disables Security
@Import(DataLoaderCommandLine.class) // Sample if you want to a bean that you dont want to mock
public class JsonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductRepository productRepository;

    @MockBean
    TransactionRepository transactionRepository;



    //rs temp @Test
    public void mockMvcGetTest() throws Exception {

        Product product = new Product("test");

        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(product));

        mockMvc.perform( MockMvcRequestBuilders
                .get("/products/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").exists());

    }

    //rs temp @Test
    public void mockMVCPutTest() throws Exception {

        Product currentProduct = new Product("oldValue");
        Product updateProduct = new Product("newValue");

        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(updateProduct));
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(updateProduct);

        String jsonString = new ObjectMapper().writeValueAsString(updateProduct);

        mockMvc.perform( MockMvcRequestBuilders
                .put("/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("newValue"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").exists());

    }


    //rs temp @Test
    public void mockMVCPostTest() throws Exception {

        Product newProduct = new Product("newValue");

        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(newProduct);

        String jsonString = new ObjectMapper().writeValueAsString(newProduct);

        mockMvc.perform( MockMvcRequestBuilders
                .post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("newValue"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").exists());

    }


    //rs temp @Test
    public void mockMVCDeleteTest() throws Exception {

        Product newProduct = new Product("newValue");

        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(newProduct);

        String jsonString = new ObjectMapper().writeValueAsString(newProduct);

        mockMvc.perform( MockMvcRequestBuilders
                .delete("/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("Deleted"));

    }


}
