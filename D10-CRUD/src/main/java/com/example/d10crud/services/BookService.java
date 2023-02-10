package com.example.d10crud.services;

import com.example.d10crud.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<BookEntity> getAll();

    List<BookEntity> getById(long id);

    long insertBook(BookEntity bookEntity);

    void updateBookById(BookEntity bookEntity, long id);

    void deleteById(long id);
}
