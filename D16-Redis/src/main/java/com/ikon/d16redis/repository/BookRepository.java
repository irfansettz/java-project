package com.ikon.d16redis.repository;

import com.ikon.d16redis.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}
