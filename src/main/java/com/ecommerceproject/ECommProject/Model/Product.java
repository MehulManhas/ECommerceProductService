package com.ecommerceproject.ECommProject.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;

    private  String description;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToOne
    private Price price;
    @ManyToMany(mappedBy = "product")
    private List<ProductOrder> productOrders;
}
