package com.ecommerceproject.ProductService.Service;

import com.ecommerceproject.ProductService.Client.FakeStoreAPIClient;
import com.ecommerceproject.ProductService.Dto.*;
import com.ecommerceproject.ProductService.Exception.ProductNotFoundException;
import com.ecommerceproject.ProductService.Model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ecommerceproject.ProductService.Mapper.ProductMapper.fakeStoreProductResponseToProductResponse;
import static com.ecommerceproject.ProductService.Mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.ecommerceproject.ProductService.Utils.ProductUtils.isNull;

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

    @Override
    public ProductResponseDto findProductByTitle(String title) {
        return null;
    }
}
