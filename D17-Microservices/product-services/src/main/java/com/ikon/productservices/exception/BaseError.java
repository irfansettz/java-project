package com.ikon.productservices.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseError extends RuntimeException {
    public String Message = "Ups, Something Went Wrong";
}
