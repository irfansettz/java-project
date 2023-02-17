package com.ikon.d13crudswagger.service.impl;

import com.ikon.d13crudswagger.entity.Product;
import com.ikon.d13crudswagger.respository.ProductRepository;
import com.ikon.d13crudswagger.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        product.add(productRepository.findById(id).get());
        return product;
    }

    @Override
    public List<Product> updateProductById(Product product, Long id) {
        Product updated = productRepository.findById(id).get();
        updated.setName(product.getName());
        updated.setDescription(product.getDescription());
        updated.setStock(product.getStock());
        updated.setPrice(product.getPrice());
        long idUpdate = productRepository.save(updated).getId();

        List<Product> updatedProduct = new ArrayList<>();
        updatedProduct.add(productRepository.findById(idUpdate).get());
        return updatedProduct;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> createProduct(Product product) {
        List<Product> newProduct = new ArrayList<>();
        Long id = productRepository.save(product).getId();

        newProduct.add(productRepository.findById(id).get());
        return newProduct;
    }


}
