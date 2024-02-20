package com.ecommerceproject.ProductService.Controller.ControllerAdvice;

import com.ecommerceproject.ProductService.Dto.ErrorResponseDto;
import com.ecommerceproject.ProductService.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleProductNotFoundException(Exception ex){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setErrorCode(404);

        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

}
