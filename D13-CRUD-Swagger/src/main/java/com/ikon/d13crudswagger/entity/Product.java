package com.ikon.d13crudswagger.entity;

//import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer stock;

    private double price;

    public Product(long id, String name, String description, int stock, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }
}
