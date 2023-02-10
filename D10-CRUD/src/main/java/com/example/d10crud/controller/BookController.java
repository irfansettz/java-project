package com.example.d10crud.controller;

import com.example.d10crud.dto.ResponseBook;
import com.example.d10crud.entity.BookEntity;
import com.example.d10crud.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseBook getAllBook(){
        ResponseBook response = new ResponseBook();
        response.setCode(200);
        response.setMessage("success");
        response.setData(bookService.getAll());
        return response;
    }

    @GetMapping("/{id}")
    public ResponseBook getBookById(@PathVariable long id){
        ResponseBook response = new ResponseBook();
        response.setCode(200);
        response.setMessage("success");
        response.setData(bookService.getById(id));
        return response;
    }

    @PostMapping
    public ResponseBook insertBook(@RequestBody BookEntity bookEntity){
        long bookInserted = bookService.insertBook(bookEntity);

        ResponseBook response = new ResponseBook();
        response.setCode(201);
        response.setMessage("Data created");
        response.setData(bookService.getById(bookInserted));
        return response;
    }

    @PutMapping("/{id}")
    public ResponseBook updateBook(@RequestBody BookEntity bookEntity, @PathVariable long id){
        bookService.updateBookById(bookEntity, id);

        ResponseBook response = new ResponseBook();
        response.setCode(201);
        response.setMessage("Data Updated");
        response.setData(bookService.getById(id));
        return  response;
    }

    @DeleteMapping("/{id}")
    public ResponseBook deleteBook(@PathVariable long id){
        bookService.deleteById(id);

        ResponseBook response = new ResponseBook();
        response.setCode(201);
        response.setMessage("Data deleted");
        return response;
    }
}
