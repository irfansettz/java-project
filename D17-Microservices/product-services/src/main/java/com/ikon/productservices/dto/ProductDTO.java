package com.ikon.productservices.dto;

import com.ikon.productservices.entity.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ProductDTO extends ResponseDTO {
    private List<Product> data;
}
