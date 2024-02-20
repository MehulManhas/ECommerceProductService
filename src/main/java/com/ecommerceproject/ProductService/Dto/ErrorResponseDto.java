package com.ecommerceproject.ProductService.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
    private String message;
    private int errorCode;
}
