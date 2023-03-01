package com.ikon.orderservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseError extends RuntimeException {
    public String message = "Ups, Something Went Wrong";
}
