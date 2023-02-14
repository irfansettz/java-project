package com.example.d10crud.dto;

import com.example.d10crud.entity.BookEntity;
import lombok.Data;

import java.util.List;

@Data
public class ResponseBookDTO {
    private Integer code;
    private String message;
    private List<BookEntity> data;
}
