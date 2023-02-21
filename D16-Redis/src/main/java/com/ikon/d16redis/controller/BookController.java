package com.ikon.d16redis.controller;

import com.ikon.d16redis.dto.BookDTO;
import com.ikon.d16redis.dto.ResponseDTO;
import com.ikon.d16redis.model.Book;
import com.ikon.d16redis.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<BookDTO> getAllBook(){
        BookDTO books = new BookDTO();
        books.setData((List<Book>) bookRepository.findAll());
        books.setCode(200);
        books.setMessage("success");

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable String id){
        Book getbook = bookRepository.findById(id).get();
        List<Book> responseBook = new ArrayList<>();
        responseBook.add(getbook);
        BookDTO response = new BookDTO();
        response.setCode(200);
        response.setMessage("success");
        response.setData(responseBook);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createBook(@RequestBody Book book){
        UUID uuid = UUID.randomUUID();
        Book newBook = new Book(uuid.toString(), book.getIsbn(), book.getPenulis(), book.getJudul(), book.getDeskripsi(), book.getKategori());
        bookRepository.save(newBook);

        ResponseDTO response = new ResponseDTO();
        response.setCode(201);
        response.setMessage("created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateBookById(@RequestBody Book book, @PathVariable String id){
        Book updateBook = bookRepository.findById(id).get();
        updateBook.setIsbn(book.getIsbn());
        updateBook.setJudul(book.getJudul());
        updateBook.setPenulis(book.getPenulis());
        updateBook.setDeskripsi(book.getDeskripsi());
        updateBook.setKategori(book.getKategori());
        bookRepository.save(updateBook);

        ResponseDTO response = new ResponseDTO();
        response.setCode(201);
        response.setMessage("updated");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteBookById(@PathVariable String id){
        bookRepository.deleteById(id);

        return new ResponseEntity<>(new ResponseDTO(201, "deleted"), HttpStatus.ACCEPTED);
    }
}
