package com.ecommerceproject.ProductService.Controller;

import com.ecommerceproject.ProductService.Dto.ProductListResponseDto;
import com.ecommerceproject.ProductService.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean(name="productService")
    private ProductService productService;

    @Test
    void getAllProductsReturnEmptyListWhenNoProductsAvailable() throws Exception {
        ProductListResponseDto productListResponseDto = new ProductListResponseDto();
        when(productService.getAllProducts()).thenReturn(productListResponseDto);

        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(""));

    }

    @Test
    void getProductFromId() {
    }

    @Test
    void getProductByTitle() {
    }

    @Test
    void createProduct() {
    }

    @Test
    void deleteProduct() {
    }
}