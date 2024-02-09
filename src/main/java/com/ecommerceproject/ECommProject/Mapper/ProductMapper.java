package com.ecommerceproject.ECommProject.Mapper;

import com.ecommerceproject.ECommProject.Dto.*;
import com.ecommerceproject.ECommProject.Model.Product;

import java.util.List;

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

    public static ProductListResponseDto productListToProductResponseDto(List<Product> productList){

        ProductListResponseDto productListResponseDto = new ProductListResponseDto();

        for(Product p : productList){
            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDto.setPrice(p.getPrice().getAmount());
            productResponseDto.setId(p.getId());
            productResponseDto.setTitle(p.getTitle());
            productResponseDto.setDescription(p.getDescription());
            productResponseDto.setImage(p.getImage());
            productResponseDto.setCategory(p.getCategory().getCategoryName());

            productListResponseDto.getProductList().add(productResponseDto);
        }

        return productListResponseDto;
    }

    public static ProductResponseDto productToProductResponseDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setPrice(product.getPrice().getAmount());
        productResponseDto.setId(product.getId());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setImage(product.getImage());
        productResponseDto.setCategory(product.getCategory().getCategoryName());

        return productResponseDto;
    }
}
