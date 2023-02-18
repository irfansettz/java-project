package com.ikon.d13crudswagger.controller;

import com.ikon.d13crudswagger.entity.Product;
import com.ikon.d13crudswagger.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void setup() {
        mockMvc = standaloneSetup(productController).build();
    }

    @Test
    public void testGetAllProduct() throws Exception {
        Product product1 = new Product(1L, "Product 1", "ini product 1",  1, 1000.0);
        Product product2 = new Product(2L, "Product 2", "ini product 2",  2, 2000.0);
        List<Product> productList = List.of(product1, product2);

        when(productService.getAllProduct()).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/products")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"code\":200,\"message\":\"success\",\"data\":[{\"id\":1,\"name\":\"Product 1\",\"description\":\"ini product 1\",\"stock\":1,\"price\":1000},{\"id\":2,\"name\":\"Product 2\",\"description\":\"ini product 2\",\"stock\":2,\"price\":2000}]}"));
    }

    @Test
    public void  testGetProductById() throws Exception{
        Product product1 = new Product(1L, "Product 1", "ini product 1",  1, 1000.0);
        List<Product> productList = List.of(product1);

        when(productService.getProductById(1L)).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/products/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"code\":200,\"message\":\"success\",\"data\":[{\"id\":1,\"name\":\"Product 1\",\"description\":\"ini product 1\",\"stock\":1,\"price\":1000}]}"));
    }

    @Test
    public void testCreateProduct() throws Exception{
        String response = "{\"code\":201,\"message\":\"Data created\",\"data\":[{\"id\":1,\"name\":\"Product 1\",\"description\":\"ini product 1\",\"stock\":1,\"price\":1000}]}";
        Product product1 = new Product(1L, "Product 1", "ini product 1",  1, 1000.0);
        List<Product> result = List.of(product1);
        lenient().when(productService.createProduct(product1)).thenReturn(result);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(response))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void testUpdateProductById() throws Exception{
        String response = "{\"code\":201,\"message\":\"data updated\",\"data\":[{\"id\":1,\"name\":\"Product 1 updated\",\"description\":\"in product 1\",\"stock\":1,\"price\":1000}]}";

        Product product1 = new Product(1L, "Product 1", "ini product 1",  1, 1000.0);
        Product productUpdate = new Product(1L, "Product 1 updated", "ini product 1",  1, 1000.0);
        List<Product> productList = List.of(productUpdate);

        lenient().when(productService.updateProductById(product1, 1L)).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/api/products/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(response))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void testDeleteProduct() throws Exception{
        String response = "{\"code\":201,\"message\":\"data deleted\"}";

        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/api/products/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(response))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
