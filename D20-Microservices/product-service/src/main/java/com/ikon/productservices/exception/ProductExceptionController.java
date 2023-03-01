package com.ikon.productservices.exception;

import com.ikon.productservices.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ResponseDTO> productNotFound(ProductNotFound e){
        ResponseDTO response = new ResponseDTO();
        response.setCode(404);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MerchantNotFound.class)
    public ResponseEntity<ResponseDTO> merchantNotFound(MerchantNotFound e){
        ResponseDTO response = new ResponseDTO();
        response.setCode(404);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BaseError.class)
    public ResponseEntity<ResponseDTO> baseError(BaseError e){
        ResponseDTO response = new ResponseDTO();
        response.setCode(500);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }
}
