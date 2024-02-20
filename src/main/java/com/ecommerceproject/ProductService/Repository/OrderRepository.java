package com.ecommerceproject.ProductService.Repository;

import com.ecommerceproject.ProductService.Model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<ProductOrder, UUID> {
}