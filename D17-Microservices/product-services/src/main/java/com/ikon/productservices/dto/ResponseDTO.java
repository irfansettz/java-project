package com.ikon.productservices.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseDTO {
    private Integer code;
    private String message;
}
