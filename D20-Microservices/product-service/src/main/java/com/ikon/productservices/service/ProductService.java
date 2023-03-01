package com.ikon.productservices.service;

import com.ikon.productservices.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProduct();

    List<Product> getProductById(Long id);

    List<Product> createdProduct(Product product);

    List<Product> updateProductById(Product product, Long id);

    void deleteProductById(Long id);
}
