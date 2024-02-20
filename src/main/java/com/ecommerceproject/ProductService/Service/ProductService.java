package com.ecommerceproject.ProductService.Service;

import com.ecommerceproject.ProductService.Dto.ProductListResponseDto;
import com.ecommerceproject.ProductService.Dto.ProductRequestDto;
import com.ecommerceproject.ProductService.Dto.ProductResponseDto;
import com.ecommerceproject.ProductService.Exception.ProductNotFoundException;
import com.ecommerceproject.ProductService.Model.Product;

public interface ProductService {
    ProductListResponseDto getAllProducts() throws ProductNotFoundException;
    ProductResponseDto getProductById(int productId) throws ProductNotFoundException;
    ProductResponseDto createProduct(ProductRequestDto newProduct);
    boolean deleteProduct(int productId);
    Product updateProduct(int productId, Product updatedProduct);

    ProductResponseDto findProductByTitle(String title) throws ProductNotFoundException;
}
