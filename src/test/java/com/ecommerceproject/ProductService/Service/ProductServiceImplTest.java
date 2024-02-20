package com.ecommerceproject.ProductService.Service;

import com.ecommerceproject.ProductService.Dto.ProductResponseDto;
import com.ecommerceproject.ProductService.Exception.InvalidTitleException;
import com.ecommerceproject.ProductService.Exception.ProductNotFoundException;
import com.ecommerceproject.ProductService.Model.Category;
import com.ecommerceproject.ProductService.Model.Price;
import com.ecommerceproject.ProductService.Model.Product;
import com.ecommerceproject.ProductService.Repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;
    @BeforeEach
    public void setup(){
        System.out.println("Before each sout");
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getAllProducts() {

    }

    @Test
    void getProductById() {
    }

    @Test
    void createProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void testFindProductByTitleSuccess() throws ProductNotFoundException {

        Price mockPrice = new Price();
        mockPrice.setAmount(100);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("mockCategory");

        String testTitle = "testTitle";
        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("testDescription");
        mockProduct.setPrice(mockPrice);
        mockProduct.setCategory(mockCategory);

        when(productRepository.findByTitle(testTitle)).thenReturn(mockProduct);

        ProductResponseDto actualProductResponseDto = productService.findProductByTitle(testTitle);

        Assertions.assertEquals(actualProductResponseDto.getTitle(), mockProduct.getTitle());
        Assertions.assertEquals(actualProductResponseDto.getId(), mockProduct.getId());
        Assertions.assertEquals(actualProductResponseDto.getPrice(), mockProduct.getPrice().getAmount());
        Assertions.assertEquals(actualProductResponseDto.getDescription(), mockProduct.getDescription());

    }

    @Test
    public void testFindByProductByTitleRepoRespondsWithNullObject() throws ProductNotFoundException{
        String testTitle = "testProductTitle";
        when(productRepository.findByTitle(testTitle)).thenReturn(null);
        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.findProductByTitle(testTitle));
    }

    @Test
    public void testFindProductByTitle_NullTitle(){
        Price mockPrice = new Price();
        mockPrice.setAmount(100);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("mockCategory");

        String testTitle = null;
        Product mockProduct = new Product();
        mockProduct.setTitle(testTitle);
        mockProduct.setCategory(mockCategory);
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setDescription("testDescription");
        mockPrice.setAmount(mockPrice.getAmount());

        when(productRepository.findByTitle(testTitle)).thenReturn(mockProduct);

        Assertions.assertThrows(InvalidTitleException.class, () -> productService.findProductByTitle(testTitle));
    }
}