package com.ecommerceproject.ECommProject.Controller;

import com.ecommerceproject.ECommProject.Dto.ProductListResponseDto;
import com.ecommerceproject.ECommProject.Dto.ProductRequestDto;
import com.ecommerceproject.ECommProject.Dto.ProductResponseDto;
import com.ecommerceproject.ECommProject.Exception.ProductNotFoundException;
import com.ecommerceproject.ECommProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

//    @Qualifier("fakeStoreProductService")
//    private ProductService productService;

    @Autowired
    private ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/products")
    public ResponseEntity getAllProducts() throws ProductNotFoundException {
//        ProductResponseDto p1 = new ProductResponseDto();
//        p1.setId(1);
//        p1.setCategory("electronics");
//        p1.setTitle("Iphone");
//        p1.setDescription("its a phone");
//        p1.setImage("www.google.com/iphone");
//        p1.setPrice(150000);
//
//        ProductResponseDto p2 = new ProductResponseDto();
//
//        p2.setId(2);
//        p2.setCategory("electronics");
//        p2.setTitle("macbook");
//        p2.setDescription("its a tab");
//        p2.setImage("www.google.com/macbook");
//        p2.setPrice(200000);
//
//        List<ProductResponseDto> products = Arrays.asList(p1, p2);
//        return ResponseEntity.ok(products);
        ProductListResponseDto productListResponseDto = productService.getAllProducts();
        return ResponseEntity.ok(productListResponseDto);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductFromId(@PathVariable("id") int id) throws ProductNotFoundException {
        ProductResponseDto response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto responseDto = productService.createProduct(productRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id){
        boolean productResponse = productService.deleteProduct(id);
        return ResponseEntity.ok(productResponse);
    }

}
