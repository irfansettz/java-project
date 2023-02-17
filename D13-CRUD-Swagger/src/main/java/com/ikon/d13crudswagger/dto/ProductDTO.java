package com.ikon.d13crudswagger.dto;

import com.ikon.d13crudswagger.entity.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ProductDTO extends ResponseDTO {
    private List<Product> data;
}
