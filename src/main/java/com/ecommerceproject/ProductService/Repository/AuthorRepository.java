package com.ecommerceproject.ProductService.Repository;

import com.ecommerceproject.ProductService.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
