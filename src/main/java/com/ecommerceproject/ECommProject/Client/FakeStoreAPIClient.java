package com.ecommerceproject.ECommProject.Client;

import com.ecommerceproject.ECommProject.Dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreAPIClient {

    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreAPIBaseURL;
    private String fakeStoreAPIProductPath;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder,
                                @Value("${fakestore.api.url}") String fakeStoreAPIBaseURL,
                              @Value("${fakestore.api.path.product}") String fakeStoreAPIProductPath)
    {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIBaseURL = fakeStoreAPIBaseURL;
        this.fakeStoreAPIProductPath = fakeStoreAPIProductPath;
    }

    public FakeStoreProductResponseDto createProduct(FakeStoreProductRequestDto fakeStoreProductRequestDto){
        String createProductURL = fakeStoreAPIBaseURL + fakeStoreAPIProductPath;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto> responseEntity = restTemplate.postForEntity(createProductURL, fakeStoreProductRequestDto, FakeStoreProductResponseDto.class);

        return responseEntity.getBody();
    }

    public FakeStoreProductResponseDto getProductById(int id){
        String getProductByIdURL = fakeStoreAPIBaseURL + fakeStoreAPIProductPath + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductResponseDto> responseEntity = restTemplate.getForEntity(getProductByIdURL, FakeStoreProductResponseDto.class);

        return responseEntity.getBody();
    }

    public List<FakeStoreProductResponseDto> getAllProducts(){
        String getAllProductByIdURL = fakeStoreAPIBaseURL + fakeStoreAPIProductPath;
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductResponseDto[]> productResponseArray = restTemplate.getForEntity(getAllProductByIdURL, FakeStoreProductResponseDto[].class);

        return List.of(Objects.requireNonNull(productResponseArray.getBody()));
    }

    public void deleteProduct(int id){
        String deleteProductByIdURL = fakeStoreAPIBaseURL + fakeStoreAPIProductPath + "/" + id;;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductByIdURL);

    }
}
