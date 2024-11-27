package com.spring1.trendyol_odevi.category.web;

import com.spring1.trendyol_odevi.category.api.CategoryDTO;
import com.spring1.trendyol_odevi.category.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequest categoryRequest) {
        CategoryDTO savedCategory = categoryService.save(toDto(categoryRequest));
        return toResponse(savedCategory);
    }

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable("id") String id) {
        CategoryDTO CategoryDTO = categoryService.findById(id);
        return toResponse(CategoryDTO);
    }

    private CategoryDTO toDto(CategoryRequest request) {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryName(request.getCategoryName());
        return dto;
    }

    private CategoryResponse toResponse(CategoryDTO dto) {
        CategoryResponse response = new CategoryResponse();
        response.setCategoryId(dto.getCategoryId());
        response.setCategoryName(dto.getCategoryName());
        return response;
    }
}
