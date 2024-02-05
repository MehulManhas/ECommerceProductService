package com.ecommerceproject.ECommProject.Service;

import com.ecommerceproject.ECommProject.Client.FakeStoreAPIClient;
import com.ecommerceproject.ECommProject.Dto.*;
import com.ecommerceproject.ECommProject.Exception.ProductNotFoundException;
import com.ecommerceproject.ECommProject.Model.Product;
import com.ecommerceproject.ECommProject.Utils.ProductUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.ecommerceproject.ECommProject.Mapper.ProductMapper.fakeStoreProductResponseToProductResponse;
import static com.ecommerceproject.ECommProject.Mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.ecommerceproject.ECommProject.Utils.ProductUtils.isNull;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDto getAllProducts() throws ProductNotFoundException {
        List<FakeStoreProductResponseDto> fakeStoreProductResponseDtoList = fakeStoreAPIClient.getAllProducts();

        if(isNull(fakeStoreProductResponseDtoList)){
            throw new ProductNotFoundException("Product not found");
        }

        ProductListResponseDto productResponseDtos = new ProductListResponseDto();

        for(FakeStoreProductResponseDto fakeStoreProductResponseDto : fakeStoreProductResponseDtoList){
            productResponseDtos.getProductList().add(fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDto));
        }

        return productResponseDtos;
    }

    @Override
    public ProductResponseDto getProductById(int productId) throws ProductNotFoundException {

        FakeStoreProductResponseDto fakeStoreProductResponseDto = fakeStoreAPIClient.getProductById(productId);

        if(isNull(fakeStoreProductResponseDto)){
            throw new ProductNotFoundException("Product not found with id : " + productId);
        }

        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDto);
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto newProduct) {
        String postProductURL = "https://fakestoreapi.com/products/";
        FakeStoreProductRequestDto fakeStoreProductRequestDto = productRequestToFakeStoreProductRequest(newProduct);
        FakeStoreProductResponseDto fakeStoreProductResponseDto = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDto);

//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        ResponseEntity<ProductResponseDto> newProductResponse = restTemplate.postForEntity(postProductURL, newProduct, ProductResponseDto.class);

        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDto);
    }

    @Override
    public boolean deleteProduct(int productId) {
        fakeStoreAPIClient.deleteProduct(productId);
        return true;
    }

    @Override
    public Product updateProduct(int productId, Product updatedProduct) {
        return null;
    }
}
