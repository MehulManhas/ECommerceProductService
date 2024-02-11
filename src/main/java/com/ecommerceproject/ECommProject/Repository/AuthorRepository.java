package com.ecommerceproject.ECommProject.Repository;

import com.ecommerceproject.ECommProject.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
