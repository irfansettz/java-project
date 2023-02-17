package com.ikon.d13crudswagger.service;

import com.ikon.d13crudswagger.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProduct();

    List<Product> createProduct(Product product);

    List<Product> getProductById(Long id);

    List<Product> updateProductById(Product product, Long id);

    void deleteProductById(Long id);
}
