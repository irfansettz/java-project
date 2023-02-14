package com.example.d10crud.controller;

import com.example.d10crud.dto.ResponseBookDTO;
import com.example.d10crud.entity.BookEntity;
import com.example.d10crud.services.BookService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseBookDTO getAllBook(){
        ResponseBookDTO response = new ResponseBookDTO();
        response.setCode(200);
        response.setMessage("success");
        response.setData(bookService.getAll());
        return response;
    }

    @GetMapping("/{id}")
    public ResponseBookDTO getBookById(@PathVariable long id){
        ResponseBookDTO response = new ResponseBookDTO();
        response.setCode(200);
        response.setMessage("success");
        response.setData(bookService.getById(id));
        return response;
    }

    @PostMapping
    public ResponseBookDTO insertBook(@RequestBody BookEntity bookEntity){
        long bookInserted = bookService.insertBook(bookEntity);

        ResponseBookDTO response = new ResponseBookDTO();
        response.setCode(201);
        response.setMessage("Data created");
        response.setData(bookService.getById(bookInserted));
        return response;
    }

    @PutMapping("/{id}")
    public ResponseBookDTO updateBook(@RequestBody BookEntity bookEntity, @PathVariable long id){
        bookService.updateBookById(bookEntity, id);

        ResponseBookDTO response = new ResponseBookDTO();
        response.setCode(201);
        response.setMessage("Data Updated");
        response.setData(bookService.getById(id));
        return  response;
    }

    @PutMapping()
    public ResponseBookDTO updateReaderById(@RequestParam long id, long reader_id){
        BookEntity book = bookService.updateReader(id, reader_id);

        List<BookEntity> bookList = new ArrayList<>();
        bookList.add(book);

        ResponseBookDTO response = new ResponseBookDTO();
        response.setCode(201);
        response.setMessage("Data updated");
        response.setData(bookList);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseBookDTO deleteBook(@PathVariable long id){
        bookService.deleteById(id);

        ResponseBookDTO response = new ResponseBookDTO();
        response.setCode(201);
        response.setMessage("Data deleted");
        return response;
    }
}
