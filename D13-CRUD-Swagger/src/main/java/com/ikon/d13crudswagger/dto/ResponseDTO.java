package com.ikon.d13crudswagger.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Data
@RequiredArgsConstructor
public class ResponseDTO {
    private Integer code;
    private String message;
}
