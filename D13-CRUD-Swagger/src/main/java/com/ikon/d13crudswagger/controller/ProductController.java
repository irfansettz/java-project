package com.ikon.d13crudswagger.controller;

import com.ikon.d13crudswagger.dto.ProductDTO;
import com.ikon.d13crudswagger.dto.ResponseDTO;
import com.ikon.d13crudswagger.entity.Product;
import com.ikon.d13crudswagger.exception.ProductNotFoundException;
import com.ikon.d13crudswagger.respository.ProductRepository;
import com.ikon.d13crudswagger.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<ProductDTO> getAllProduct(){
        List<Product> allProduct = productService.getAllProduct();

        ProductDTO response = new ProductDTO();
        response.setCode(200);
        response.setMessage("success");
        response.setData(allProduct);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        if (productRepository.findById(id).isEmpty()) throw new ProductNotFoundException("Product Not Found");
        List<Product> product =  productService.getProductById(id);
        ProductDTO response = new ProductDTO();
        response.setCode(200);
        response.setMessage("success");
        response.setData(product);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product){
        List<Product> newProduct = productService.createProduct(product);
        ProductDTO response = new ProductDTO();
        response.setCode(201);
        response.setMessage("Data created");
        response.setData(newProduct);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@RequestBody Product product, @PathVariable Long id){
        if (productRepository.findById(id).isEmpty()) throw new ProductNotFoundException("Product Not Found");
        List<Product> updatedProduct = productService.updateProductById(product, id);
        ProductDTO response = new ProductDTO();
        response.setCode(201);
        response.setMessage("data updated");
        response.setData(updatedProduct);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteProductById(@PathVariable Long id){
        if (productRepository.findById(id).isEmpty()) throw new ProductNotFoundException("Product Not Found");
        productService.deleteProductById(id);
        ResponseDTO response = new ResponseDTO();
        response.setCode(201);
        response.setMessage("data deleted");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
