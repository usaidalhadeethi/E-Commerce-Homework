package com.spring1.trendyol_odevi.repository;

import com.spring1.trendyol_odevi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    public Optional<Product> findById (int productId);
}
