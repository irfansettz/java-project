package com.ikon.d13crudswagger.service.impl;

import com.ikon.d13crudswagger.entity.Product;
import com.ikon.d13crudswagger.respository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Mock
    protected ProductRepository productRepository;

    @Test
    void testGetALlProduct(){
        Product product1 = new Product(1L, "Product 1", "ini product 1",  1, 1000.0);
        Product product2 = new Product(2L, "Product 2", "ini product 2",  2, 2000.0);
        List<Product> productList = List.of(product1, product2);

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> actual = productServiceImpl.getAllProduct();
        Assertions.assertEquals(productList, actual);
    }

    @Test
    void testGetProductById(){
        Product product1 = new Product(1L, "Product 1", "ini product 1",  1, 1000.0);
        List<Product> productList = List.of(product1);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));

        List<Product> actual = productServiceImpl.getProductById(1L);
        Assertions.assertEquals(productList, actual);
    }

    @Test
    void testCreatedProduct(){
        Product product1 = new Product(1L, "Product 1", "ini product 1",  1, 1000.0);
        List<Product> productList = List.of(product1);

        when(productRepository.save(product1)).thenReturn(product1);

        List<Product> actual = productServiceImpl.createProduct(product1);
        Assertions.assertEquals(productList, actual);
    }

    @Test
    void testUpdateProductById(){
        Product product1 = new Product(1L, "Product 1", "ini product 1",  1, 1000.0);
        Product productUpdate = new Product(1L, "Product 1 updated", "ini product 1",  1, 1000.0);
        List<Product> productList = List.of(productUpdate);

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product1));
        when(productRepository.save(productUpdate)).thenReturn(productUpdate);

        List<Product> actual = productServiceImpl.updateProductById(productUpdate, anyLong());
        Assertions.assertEquals(productList, actual);
    }

    @Test
    void testDeleteProductById(){
        // Given
        Long id = 1L;
        lenient().when(productRepository.findById(id)).thenReturn(Optional.ofNullable(null));

        productServiceImpl.deleteProductById(id);

        verify(productRepository).deleteById(id);
    }
}
