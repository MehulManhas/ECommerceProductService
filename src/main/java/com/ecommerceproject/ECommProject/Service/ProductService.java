package com.ecommerceproject.ECommProject.Service;

import com.ecommerceproject.ECommProject.Dto.ProductListResponseDto;
import com.ecommerceproject.ECommProject.Dto.ProductRequestDto;
import com.ecommerceproject.ECommProject.Dto.ProductResponseDto;
import com.ecommerceproject.ECommProject.Exception.ProductNotFoundException;
import com.ecommerceproject.ECommProject.Model.Product;

import java.util.List;

public interface ProductService {
    ProductListResponseDto getAllProducts() throws ProductNotFoundException;
    ProductResponseDto getProductById(int productId) throws ProductNotFoundException;
    ProductResponseDto createProduct(ProductRequestDto newProduct);
    boolean deleteProduct(int productId);
    Product updateProduct(int productId, Product updatedProduct);
}
