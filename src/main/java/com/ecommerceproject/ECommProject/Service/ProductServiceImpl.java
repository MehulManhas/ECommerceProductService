package com.ecommerceproject.ECommProject.Service;

import com.ecommerceproject.ECommProject.Dto.ProductListResponseDto;
import com.ecommerceproject.ECommProject.Dto.ProductRequestDto;
import com.ecommerceproject.ECommProject.Dto.ProductResponseDto;
import com.ecommerceproject.ECommProject.Mapper.ProductMapper;
import com.ecommerceproject.ECommProject.Model.Product;
import com.ecommerceproject.ECommProject.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductListResponseDto getAllProducts() {
        List<Product> products = productRepository.findAll();
        ProductListResponseDto productListResponseDto = ProductMapper.productListToProductResponseDto(products);
        return productListResponseDto;
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

    @Override
    public ProductResponseDto findProductByTitle(String title) {
        Product product = productRepository.findByTitle(title);
        ProductResponseDto responseDto = ProductMapper.productToProductResponseDto(product);
        return responseDto;
    }
}
