package com.spring1.trendyol_odevi.service;

import com.spring1.trendyol_odevi.entity.Category;
import com.spring1.trendyol_odevi.repository.CategoryRepository;
import com.spring1.trendyol_odevi.service.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryDTO save(CategoryDTO dto) {
        Category category = toEntity(dto);
        categoryRepository.save(category);
        return toDto(category);
    }

    public CategoryDTO findById(String id) {
        Category category = categoryRepository.findById(Integer.parseInt(id)).orElse(null);
        return toDto(category);
    }

    private Category toEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        return category;
    }

    private CategoryDTO toDto(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        return dto;
    }
}
