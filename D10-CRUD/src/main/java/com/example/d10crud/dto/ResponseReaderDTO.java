package com.example.d10crud.dto;

import com.example.d10crud.entity.ReaderEntity;
import lombok.Data;

import java.util.List;

@Data
public class ResponseReaderDTO {
    private Integer code;
    private String message;
    private List<ReaderEntity> data;
}
