package com.ecommerceproject.ECommProject.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRequestDto {
    private String title;
    private double price;
    private String category;
    private  String description;
    private String image;
}
