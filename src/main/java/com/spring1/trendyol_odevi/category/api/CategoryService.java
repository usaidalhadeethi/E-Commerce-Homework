package com.spring1.trendyol_odevi.category.api;

import com.spring1.trendyol_odevi.Product.api.ProductDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO findById(String id);
    List<CategoryDTO> findAll();
    void deleteById(String id);
}
