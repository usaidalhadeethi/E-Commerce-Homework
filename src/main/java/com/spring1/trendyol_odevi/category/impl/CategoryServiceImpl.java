package com.spring1.trendyol_odevi.category.impl;

import com.spring1.trendyol_odevi.category.api.CategoryDTO;
import com.spring1.trendyol_odevi.category.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = toEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return toDto(savedCategory);
    }

    @Override
    public CategoryDTO findById(String id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            return toDto(categoryOptional.get());
        } else {
            throw new RuntimeException("Category not found with ID: " + id);
        }
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Category not found with ID: " + id);
        }
    }

    public Category toEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setCategoryId(dto.getCategoryId());
        category.setCategoryName(dto.getCategoryName());
        return category;
    }

    public CategoryDTO toDto(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        return dto;
    }
}
