package com.example.d10crud.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "book")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "page")
    protected Integer page;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reader_id")
    private ReaderEntity reader;
}
