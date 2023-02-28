package com.ikon.productservices.controller;

import com.ikon.productservices.dto.ProductDTO;
import com.ikon.productservices.dto.ResponseDTO;
import com.ikon.productservices.entity.Product;
import com.ikon.productservices.exception.BaseError;
import com.ikon.productservices.exception.MerchantNotFound;
import com.ikon.productservices.exception.ProductNotFound;
import com.ikon.productservices.repository.ProductRepository;
import com.ikon.productservices.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
        response.setData(allProduct);
        response.setMessage("success");
        response.setCode(200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        if (productRepository.findById(id).isEmpty()) throw new ProductNotFound("Product Not Found");
        List<Product> getProduct = productService.getProductById(id);

        ProductDTO response = new ProductDTO();
        response.setCode(200);
        response.setMessage("success");
        response.setData(getProduct);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) throws IOException {
        URL url = new URL("http://localhost:8061/v1/api/merchants/" + product.getMerchantid());

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        con.disconnect();

        if (status >= 500) throw new BaseError();
        if (status == 404 ) throw new MerchantNotFound("Merchant Not Found");
        List<Product> createProduct = productService.createdProduct(product);

        ProductDTO response = new ProductDTO();
        response.setCode(201);
        response.setMessage("created");
        response.setData(createProduct);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@RequestBody Product product, @PathVariable Long id){
        if (productRepository.findById(id).isEmpty()) throw new ProductNotFound("Product Not Found");
        List<Product> updateProductById = productService.updateProductById(product, id);

        ProductDTO response = new ProductDTO();
        response.setCode(201);
        response.setMessage("updated");
        response.setData(updateProductById);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteProductById(@PathVariable Long id){
        if (productRepository.findById(id).isEmpty()) throw new ProductNotFound("Product Not Found");
        productService.deleteProductById(id);

        ResponseDTO response = new ResponseDTO();
        response.setCode(201);
        response.setMessage("deleted");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
