package com.example.d10crud.entity;

import com.example.d10crud.services.ReaderService;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reader")
public class ReaderEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private int age;

}
