package com.spring1.trendyol_odevi.repository;

import com.spring1.trendyol_odevi.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring1.trendyol_odevi.entity.Category;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    public Optional<Category> findById (int id);
}


