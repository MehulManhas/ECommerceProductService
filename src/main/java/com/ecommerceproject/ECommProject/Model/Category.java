package com.ecommerceproject.ECommProject.Model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
