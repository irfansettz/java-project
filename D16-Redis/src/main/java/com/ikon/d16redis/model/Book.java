package com.ikon.d16redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("book")
@Data
@AllArgsConstructor
public class Book {
    private String id;
    private String isbn;
    private String judul;
    private String penulis;
    private String deskripsi;
    private String kategori;
}
