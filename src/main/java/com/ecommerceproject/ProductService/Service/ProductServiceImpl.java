package com.ecommerceproject.ProductService.Service;

import com.ecommerceproject.ProductService.Dto.ProductListResponseDto;
import com.ecommerceproject.ProductService.Dto.ProductRequestDto;
import com.ecommerceproject.ProductService.Dto.ProductResponseDto;
import com.ecommerceproject.ProductService.Exception.InvalidTitleException;
import com.ecommerceproject.ProductService.Exception.ProductNotFoundException;
import com.ecommerceproject.ProductService.Mapper.ProductMapper;
import com.ecommerceproject.ProductService.Model.Product;
import com.ecommerceproject.ProductService.Repository.ProductRepository;
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
    public ProductResponseDto findProductByTitle(String title) throws ProductNotFoundException {

        if(title == null || title.isEmpty()){
            throw new InvalidTitleException("title is invalid");
        }
        Product product = productRepository.findByTitle(title);

        if(product == null){
            throw new ProductNotFoundException("Product with given title is not available");
        }

        ProductResponseDto responseDto = ProductMapper.productToProductResponseDto(product);
        return responseDto;
    }
}
