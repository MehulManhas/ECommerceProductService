package com.ecommerceproject.ECommProject.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductListResponseDto {

    private List<ProductResponseDto> productList;

    public ProductListResponseDto(){
        this.productList = new ArrayList<>();
    }

}
