package com.ikon.productservices.service.implement;

import com.ikon.productservices.entity.Product;
import com.ikon.productservices.repository.ProductRepository;
import com.ikon.productservices.service.ProductService;
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
        List<Product> getProducts = new ArrayList<>();
        getProducts.add(productRepository.findById(id).get());
        return getProducts;
    }

    @Override
    public List<Product> createdProduct(Product product) {
        List<Product> createProduct = new ArrayList<>();
        createProduct.add(productRepository.save(product));
        return createProduct;
    }

    @Override
    public List<Product> updateProductById(Product product, Long id) {
        List<Product> updateProduct = new ArrayList<>();
        Product findProduct = productRepository.findById(id).get();
        findProduct.setDescription(product.getDescription());
        findProduct.setName(product.getName());
        findProduct.setStock(product.getStock());
        findProduct.setPrice(product.getPrice());
        findProduct.setMerchantid(product.getMerchantid());
        updateProduct.add(productRepository.save(findProduct));
        return updateProduct;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
