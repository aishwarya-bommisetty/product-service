package com.product.app.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.product.app.model.ProductModel;
import com.product.app.services.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductServiceController.class)
public class ProductServiceControllerTest {

    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private ProductService service;
 
    @Test
    public void whenGetAll_thenReturnJsonArray()
      throws Exception {
         
    	ProductModel product = new ProductModel();
        product.setName("toothbrush");
        product.setDescription("white, has bristles");
        product.setId(1);
        List<ProductModel> allProducts = Arrays.asList(product);
     
        when(service.findAll()).thenReturn(allProducts);
     
        mvc.perform(get("/Product/getAll")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(1)))
          .andExpect(jsonPath("$[0].name", is(product.getName())));
    }
    
    @Test
    public void givenNoProducts_whenGetAll_thenReturnEmptyJsonArray()
      throws Exception {
         
    	/*ProductModel product = new ProductModel();
        product.setName("toothbrush");
        product.setDescription("white, has bristles");
        product.setId(1);*/
        List<ProductModel> allProducts = new ArrayList<>();//Arrays.asList(product);
     
        when(service.findAll()).thenReturn(allProducts);
     
        mvc.perform(get("/Product/getAll")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(0)));
          
    }
    
    @Test
    public void whenGetProductById_thenReturnOneProduct()
      throws Exception {
         
    	ProductModel product = new ProductModel();
        product.setName("toothbrush");
        product.setDescription("white, has bristles");
        product.setId(1);
        
     
        when(service.findProductById(1)).thenReturn(product);
     
        mvc.perform(get("/Product/get/1")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.name", is(product.getName())));
    }
    
    @Test
    public void givenNoProducts_whenGetProductById_thenReturnNothing()
      throws Exception {
         
    	ProductModel product = new ProductModel();
        product.setName("toothbrush");
        product.setDescription("white, has bristles");
        product.setId(1);
        
     
        when(service.findProductById(1)).thenReturn(product);
     
        mvc.perform(get("/Product/get/1")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().json("{}"));
    }
    
    @Test
    public void whenAdd_thenInsertOneProduct()
      throws Exception {
         
    	ProductModel product = new ProductModel();
        product.setName("toothbrush");
        product.setDescription("white, has bristles");
        product.setId(1);
        
     
        when(service.findProductById(1)).thenReturn(product);
     
        mvc.perform(get("/Product/get/1")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.name", is(product.getName())));
    }
}

