package com.ecommerceproject.ECommProject.Dto;

import com.ecommerceproject.ECommProject.Model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDto {
    private UUID id;
    private String title;
    private double price;
    private String category;
    private  String description;
    private String image;
}
