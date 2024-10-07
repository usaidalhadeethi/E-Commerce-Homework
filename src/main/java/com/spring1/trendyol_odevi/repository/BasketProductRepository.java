package com.spring1.trendyol_odevi.repository;

import com.spring1.trendyol_odevi.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketProductRepository extends JpaRepository<BasketProductRepository, String> {
    public Optional<BasketProduct> findById (int basketProductId);
}
