package com.spring1.trendyol_odevi.basket.basketProduct.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketProductRepository extends JpaRepository<BasketProduct, String> {
    Optional<BasketProduct> findBasketProductByBasketIdAndProductId(String basketId, String productId);
}
