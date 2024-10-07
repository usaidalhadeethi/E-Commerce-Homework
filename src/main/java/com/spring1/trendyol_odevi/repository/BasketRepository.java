package com.spring1.trendyol_odevi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring1.trendyol_odevi.entity.Basket;

import java.util.Optional;

@Repository
public interface BasketRepository extends JpaRepository<Basket, String> {
    public Optional<Basket> findById (int id);
}

