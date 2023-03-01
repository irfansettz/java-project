package com.ikon.orderservice.exception;

import com.ikon.orderservice.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionController {
    @ExceptionHandler(BaseError.class)
    public ResponseEntity<ResponseDTO> baseError(BaseError e){
        ResponseDTO response = new ResponseDTO();
        response.setCode(500);
        response.setStatus(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(OrderNotFound.class)
    public ResponseEntity<ResponseDTO> orderNotFound(OrderNotFound e){
        ResponseDTO response = new ResponseDTO();
        response.setCode(404);
        response.setStatus(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ResponseDTO> productNotFound(ProductNotFound e){
        ResponseDTO response = new ResponseDTO();
        response.setCode(404);
        response.setStatus(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
