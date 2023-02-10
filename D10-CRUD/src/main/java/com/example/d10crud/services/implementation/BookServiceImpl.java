package com.example.d10crud.services.implementation;

import com.example.d10crud.entity.BookEntity;
import com.example.d10crud.repository.BookRepository;
import com.example.d10crud.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<BookEntity> getById(long id) {
        List<BookEntity> book = new ArrayList<>();
        book.add(bookRepository.findById(id).get());
        return book;
    }

    @Override
    public long insertBook(BookEntity bookEntity) {
        long newBookId = bookRepository.save(bookEntity).getId();
        return newBookId;
    }

    @Override
    public void updateBookById(BookEntity bookEntity, long id) {
        BookEntity book = bookRepository.findById(id).get();
        book.setName(bookEntity.getName());
        book.setAuthor(bookEntity.getAuthor());
        bookRepository.save(book);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

}
