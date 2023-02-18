package com.ikon.d13crudswagger.service.impl;

import com.ikon.d13crudswagger.entity.Product;
import com.ikon.d13crudswagger.respository.ProductRepository;
import com.ikon.d13crudswagger.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductById(Long id) {
        List<Product> product = new ArrayList<>();
        Optional data = productRepository.findById(id);
        product.add((Product) data.get());
        return product;
    }

    @Override
    public List<Product> createProduct(Product product) {
        List<Product> newProduct = new ArrayList<>();
        Product saveProduct = productRepository.save(product);

        newProduct.add(saveProduct);
        return newProduct;
    }

    @Override
    public List<Product> updateProductById(Product product, Long id) {
        Optional data = productRepository.findById(id);
        Product updated = (Product) data.get();
        updated.setName(product.getName());
        updated.setDescription(product.getDescription());
        updated.setStock(product.getStock());
        updated.setPrice(product.getPrice());
        Product productUpdate = productRepository.save(updated);
        List<Product> updatedProduct = new ArrayList<>();
        updatedProduct.add(productUpdate);
        return updatedProduct;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }


}
