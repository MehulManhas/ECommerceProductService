package com.ecommerceproject.ECommProject.Mapper;

import com.ecommerceproject.ECommProject.Dto.FakeStoreProductRequestDto;
import com.ecommerceproject.ECommProject.Dto.FakeStoreProductResponseDto;
import com.ecommerceproject.ECommProject.Dto.ProductRequestDto;
import com.ecommerceproject.ECommProject.Dto.ProductResponseDto;

public class ProductMapper {
    public static FakeStoreProductRequestDto productRequestToFakeStoreProductRequest(ProductRequestDto productRequestDto){
        FakeStoreProductRequestDto fakeStoreProductRequestDto = new FakeStoreProductRequestDto();
        fakeStoreProductRequestDto.setCategory(productRequestDto.getCategory());
        fakeStoreProductRequestDto.setDescription(productRequestDto.getDescription());
        fakeStoreProductRequestDto.setImage(productRequestDto.getImage());
        fakeStoreProductRequestDto.setTitle(productRequestDto.getTitle());
        fakeStoreProductRequestDto.setPrice(productRequestDto.getPrice());

        return fakeStoreProductRequestDto;
    }

    public static ProductResponseDto fakeStoreProductResponseToProductResponse(FakeStoreProductResponseDto fakeStoreProductResponseDto){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(fakeStoreProductResponseDto.getId());
        productResponseDto.setCategory(fakeStoreProductResponseDto.getCategory());
        productResponseDto.setTitle(fakeStoreProductResponseDto.getTitle());
        productResponseDto.setDescription(fakeStoreProductResponseDto.getDescription());
        productResponseDto.setImage(fakeStoreProductResponseDto.getImage());
        productResponseDto.setPrice(fakeStoreProductResponseDto.getPrice());
        return productResponseDto;
    }
}
