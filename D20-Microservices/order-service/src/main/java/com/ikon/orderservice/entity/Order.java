package com.ikon.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "order_product")
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productid;

    private Integer qty;

    @Column(name = "user_id")
    private Long userid;

    private boolean finished;

    public boolean getFinished() {
        return this.finished;
    }
}
