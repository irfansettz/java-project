package com.ikon.d16redis.dto;

import com.ikon.d16redis.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO extends ResponseDTO {
    private List<Book> data;
}
