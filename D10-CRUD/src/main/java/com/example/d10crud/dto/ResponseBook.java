package com.example.d10crud.dto;

import com.example.d10crud.entity.BookEntity;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResponseBook {
    private Integer code;
    private String message;
    private List<BookEntity> data;
}
