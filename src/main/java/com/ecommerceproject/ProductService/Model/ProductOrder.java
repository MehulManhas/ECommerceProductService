package com.ecommerceproject.ProductService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class ProductOrder extends BaseModel{
    private double price;
    @ManyToMany
    private List<Product> product;
}
