package com.ecommerceproject.ECommProject.Service;

import com.ecommerceproject.ECommProject.Dto.ProductListResponseDto;
import com.ecommerceproject.ECommProject.Dto.ProductRequestDto;
import com.ecommerceproject.ECommProject.Dto.ProductResponseDto;
import com.ecommerceproject.ECommProject.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Override
    public ProductListResponseDto getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDto getProductById(int productId) {
        return null;
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto newProduct) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }

    @Override
    public Product updateProduct(int productId, Product updatedProduct) {
        return null;
    }
}
